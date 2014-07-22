/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 22/07/2014
   Última modificación: 22/07/2014
*/

package com.nebur.teide.tienda.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nebur.teide.tienda.modelo.TiendaProducto;
import com.nebur.teide.tienda.modelo.viewforms.ProductoViewForm;
import com.nebur.teide.tienda.repositorios.RepositorioCategorias;
import com.nebur.teide.tienda.repositorios.RepositorioProductos;
import com.nebur.teide.tienda.repositorios.RepositorioTags;

@Controller
@RequestMapping(value="modificarProducto.html")
public class ProductosModificarController {
	@Autowired
	RepositorioProductos daoProd;
	@Autowired
	RepositorioCategorias daoCat;
	@Autowired
	RepositorioTags daoTags;
	
	@RequestMapping(value="/{id}")
	public String obtenerDatos(ModelMap mapaModelo, @PathVariable Integer id) {
		TiendaProducto prod = daoProd.get(TiendaProducto.class, id);
		ProductoViewForm pvf = new ProductoViewForm();
		
		pvf.fromProducto(prod);
		
		Map<Integer, String> mapaCategorias = daoCat.getMapaOptions();
		Map<Integer, String> mapaTags = daoTags .getMapaOptions();
		
		mapaModelo.addAttribute("producto", pvf);
		mapaModelo.addAttribute("categorias", mapaCategorias);
		mapaModelo.addAttribute("tags", mapaTags);
		
		
		return "modificar";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String hacerModificacion(@ModelAttribute("producto") ProductoViewForm pvf, BindingResult resultado, HttpServletRequest request) {
		if( resultado.hasErrors() )
		{
			Map<Integer, String> mapaCategorias = daoCat.getMapaOptions();
			Map<Integer, String> mapaTags = daoTags .getMapaOptions();
			
			request.setAttribute("categorias", mapaCategorias);
			request.setAttribute("tags", mapaTags);
			
			return "modificar";
		}
		
		TiendaProducto prod = pvf.getProducto();
		daoProd.update(prod);
		
		
		return "redirect:/listado.html";
	}
}
