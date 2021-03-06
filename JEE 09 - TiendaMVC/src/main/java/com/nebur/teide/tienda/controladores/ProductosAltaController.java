/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 21/07/2014
   �ltima modificaci�n: 22/07/2014
*/

package com.nebur.teide.tienda.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nebur.teide.tienda.modelo.TiendaProducto;
import com.nebur.teide.tienda.modelo.viewforms.ProductoViewForm;
import com.nebur.teide.tienda.repositorios.RepositorioCategorias;
import com.nebur.teide.tienda.repositorios.RepositorioProductos;
import com.nebur.teide.tienda.repositorios.RepositorioTags;

@Controller
@RequestMapping(value="altaProducto.html")
public class ProductosAltaController {
	@Autowired
	RepositorioCategorias daoCategorias;
	@Autowired
	RepositorioProductos daoProd;
	@Autowired
	RepositorioTags daoTags;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getDatosParaAlta(ModelMap mapaModelo) {
		ProductoViewForm producto = new ProductoViewForm();
		
		Map<Integer, String> mapaCategorias = daoCategorias.getMapaOptions();
		Map<Integer, String> mapaTags = daoTags.getMapaOptions();
		
		mapaModelo.addAttribute("producto", producto);
		mapaModelo.addAttribute("categorias", mapaCategorias);
		mapaModelo.addAttribute("tags", mapaTags);
		
		
		return "alta";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String hacerAlta(@ModelAttribute("producto") ProductoViewForm producto, BindingResult resultado, HttpServletRequest request ) {
		if( resultado.hasErrors() )
		{
			request.setAttribute("categorias", daoCategorias.getMapaOptions());
			request.setAttribute("tags", daoTags.getMapaOptions());
			
			return "alta";
		}
		
		TiendaProducto prod = producto.getProducto();
		daoProd.add(prod);
		
		
		return "redirect:/listado.html";
	}
}
