/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 18/07/2014
   Última modificación: 21/07/2014
*/

package com.nebur.teide.tienda.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nebur.teide.tienda.modelo.TiendaCategoria;

public class RepositorioCategorias extends Repositorio<TiendaCategoria> {
	@Override
	public TiendaCategoria get(Class<TiendaCategoria> tipoDato, Integer id) {
		TiendaCategoria p = super.get(tipoDato, id);
		
		
		return p;
	}
	
	public Map<Integer, String> getMapaOptions() {
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		
		List<TiendaCategoria> lista = get(TiendaCategoria.class);
		
		for (TiendaCategoria cat : lista) {
			mapa.put(cat.getIdCategoria(), cat.getNombre());
		}
		
		
		return mapa;
	}
}
