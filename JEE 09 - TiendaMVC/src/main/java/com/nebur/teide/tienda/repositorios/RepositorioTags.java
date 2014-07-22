/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 22/07/2014
   Última modificación: 22/07/2014
*/

package com.nebur.teide.tienda.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nebur.teide.tienda.modelo.TiendaTag;

public class RepositorioTags extends Repositorio<TiendaTag> {
	public Map<Integer, String> getMapaOptions() {
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		
		List<TiendaTag> lista = get(TiendaTag.class);
		
		for (TiendaTag t : lista) {
			mapa.put(t.getIdTag(), t.getNombre());
		}
		
		
		return mapa;
	}
}
