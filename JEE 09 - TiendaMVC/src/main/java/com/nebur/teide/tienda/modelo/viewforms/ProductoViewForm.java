/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 21/07/2014
   Última modificación: 22/07/2014
*/

package com.nebur.teide.tienda.modelo.viewforms;

import java.util.HashSet;
import java.util.Set;

import com.nebur.teide.tienda.modelo.TiendaCategoria;
import com.nebur.teide.tienda.modelo.TiendaProducto;
import com.nebur.teide.tienda.modelo.TiendaTag;

public class ProductoViewForm {
	private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String foto;
    private Integer existencias;
    private double precio;
    private Integer idCategoria;
    private Integer[] idsTags;
    
    
	public ProductoViewForm() {
	}
	
	public ProductoViewForm(Integer idProducto, String nombre,
			String descripcion, String foto, Integer existencias,
			double precio, Integer idCategoria, Integer[] idsTags) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.existencias = existencias;
		this.precio = precio;
		this.idCategoria = idCategoria;
		this.idsTags = idsTags;
	}
	
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Integer getExistencias() {
		return existencias;
	}
	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer[] getIdsTags() {
		return idsTags;
	}
	public void setIdsTags(Integer[] idsTags) {
		this.idsTags = idsTags;
	}
    
	
	public TiendaProducto getProducto() {
		TiendaProducto p = new TiendaProducto();
		
		p.setIdProducto(idProducto);
		p.setNombre(nombre);
		p.setDescripcion(descripcion);
		p.setFoto(foto);
		p.setExistencias(existencias);
		p.setPrecio(precio);
		
		TiendaCategoria c = new TiendaCategoria();
		c.setIdCategoria(idCategoria);
		p.setTiendaCategoria(c);
		
		Set<TiendaTag> tags = new HashSet<TiendaTag>();
		for (Integer t : idsTags) {
			TiendaTag tag = new TiendaTag();
			tag.setIdTag(t);
			tags.add(tag);
		}
		p.setTiendaTags(tags);
		
		
		return p;
	}
	
	public void fromProducto(TiendaProducto p) {
		setIdProducto(p.getIdProducto());
		setNombre(p.getNombre());
		setDescripcion(p.getDescripcion());
		setFoto(p.getFoto());
		setExistencias(p.getExistencias());
		setPrecio(p.getPrecio());
		
		setIdCategoria( p.getTiendaCategoria().getIdCategoria() );
		
		idsTags = new Integer[p.getTiendaTags().size()];
		Integer i = 0;
		for (TiendaTag t : p.getTiendaTags()) {
			idsTags[i++] = t.getIdTag();
		}
	}

}
