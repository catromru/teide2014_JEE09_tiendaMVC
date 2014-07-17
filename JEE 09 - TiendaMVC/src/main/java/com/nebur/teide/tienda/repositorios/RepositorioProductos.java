/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 17/07/2014
   �ltima modificaci�n: 17/07/2014
*/

package com.nebur.teide.tienda.repositorios;

import org.hibernate.Hibernate;

import com.nebur.teide.tienda.modelo.TiendaProducto;

public class RepositorioProductos extends Repositorio<TiendaProducto> {
	@Override
	public TiendaProducto get(Class<TiendaProducto> tipoDato, Integer id) {
		TiendaProducto p = super.get(tipoDato, id);
		
		Hibernate.initialize( p.getTiendaCategoria() );
		
		
		return p;
	}
}
