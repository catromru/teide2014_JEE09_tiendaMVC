/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 18/07/2014
   Última modificación: 18/07/2014
*/

package com.nebur.teide.tienda.repositorios;

import com.nebur.teide.tienda.modelo.TiendaCategoria;

public class RepositorioCategorias extends Repositorio<TiendaCategoria> {
	@Override
	public TiendaCategoria get(Class<TiendaCategoria> tipoDato, Integer id) {
		TiendaCategoria p = super.get(tipoDato, id);
		
		
		return p;
	}
}
