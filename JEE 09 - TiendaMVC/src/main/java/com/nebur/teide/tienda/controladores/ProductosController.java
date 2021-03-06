/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 15/07/2014
   �ltima modificaci�n: 17/07/2014
*/

package com.nebur.teide.tienda.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nebur.teide.tienda.modelo.TiendaProducto;
import com.nebur.teide.tienda.repositorios.RepositorioProductos;

@Controller
public class ProductosController {
	@Autowired
	RepositorioProductos daoProd;
	
	@RequestMapping(value="/listado.html")
	public String listar(Model modelo)
	{
		List<TiendaProducto> lista = daoProd.get(TiendaProducto.class);
		
		modelo.addAttribute("productos", lista);
		
		
		return "listado";
	}
	
	@RequestMapping(value="detalle.html")
	public String verDetalle(Model modelo, HttpServletRequest request)
	{
		Integer id = Integer.parseInt( request.getParameter("id") );
		
		TiendaProducto p = daoProd.get(TiendaProducto.class, id);
		
		modelo.addAttribute("producto", p);
		
		
		return "detalle";
	}
}
