/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 21/07/2014
   Última modificación: 21/07/2014
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

@Controller
@RequestMapping(value="altaProducto.html")
public class ProductosAltaController {
	@Autowired
	RepositorioCategorias daoCategorias;
	@Autowired
	RepositorioProductos daoProd;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getDatosParaAlta(ModelMap mapaModelo) {
		ProductoViewForm producto = new ProductoViewForm();
		Map<Integer, String> mapaCategorias = daoCategorias.getMapaOptions();
		
		mapaModelo.addAttribute("producto", producto);
		mapaModelo.addAttribute(mapaCategorias);
		
		
		return "alta";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String hacerAlta(@ModelAttribute("producto") ProductoViewForm producto, BindingResult resultado, HttpServletRequest request ) {
		if( resultado.hasErrors() )
		{
			request.setAttribute("categorias", daoCategorias.getMapaOptions());
			
			return "alta";
		}
		
		TiendaProducto prod = producto.getProducto();
		daoProd.add(prod);
		
		
		return "redirect:/listado.html";
	}
}
