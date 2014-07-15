/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 15/07/2014
   Última modificación: 15/07/2014
*/

package com.nebur.teide.tienda.controladores;

import java.util.List;

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
}
