/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 18/07/2014
   �ltima modificaci�n: 18/07/2014
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
