/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 17/07/2014
   Última modificación: 18/07/2014
*/

package com.nebur.teide.tienda.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nebur.teide.tienda.modelo.TiendaProducto;
import com.nebur.teide.tienda.repositorios.RepositorioProductos;

@Controller
@RequestMapping(value="/producto")
public class ProductosRestController {
	@Autowired
	RepositorioProductos daoProd;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody TiendaProducto verDetalle(@PathVariable Integer id)
	{
		TiendaProducto p = daoProd.get(TiendaProducto.class, id);
		
		
		return p;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="buscar/{texto}")
	public @ResponseBody List<TiendaProducto> buscarProductos(@PathVariable String texto)
	{
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<TiendaProducto> lista;
		
		if( texto.equals("BusquedaVacia") )
		{
			texto = "";
		}
		
		parametros.put("texto", "%"+texto+"%");
		
		lista = daoProd.find("producto_buscarPorNombre", parametros);
		
		
		return lista;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrarProducto(@RequestBody TiendaProducto p)
	{
		daoProd.delete(p);
		
		
		return "borrado";
	}
}
