/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 18/07/2014
   Última modificación: 18/07/2014
*/

package com.nebur.teide.tienda.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nebur.teide.tienda.modelo.TiendaCategoria;
import com.nebur.teide.tienda.repositorios.RepositorioCategorias;

@Controller
@RequestMapping(value="/categoria")
public class CategoriasRestController {
	@Autowired
	RepositorioCategorias daoCat;
	
	@RequestMapping(value="/listado.html")
	public String listar(Model modelo)
	{
		List<TiendaCategoria> lista = daoCat.get(TiendaCategoria.class);
		
		modelo.addAttribute("categorias", lista);
		
		
		return "listadoCategorias";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody TiendaCategoria verDetalle(@PathVariable Integer id)
	{
		TiendaCategoria p = daoCat.get(TiendaCategoria.class, id);
		
		
		return p;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="buscar/{texto}")
	public @ResponseBody List<TiendaCategoria> buscar(@PathVariable String texto)
	{
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<TiendaCategoria> lista;
		
		parametros.put("texto", "%"+texto+"%");
		
		lista = daoCat.find("categoria_buscarPorNombre", parametros);
		
		
		return lista;
	}
}
