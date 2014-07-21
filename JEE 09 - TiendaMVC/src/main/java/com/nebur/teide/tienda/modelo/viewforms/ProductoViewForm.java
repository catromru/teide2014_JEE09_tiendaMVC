/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 21/07/2014
   �ltima modificaci�n: 21/07/2014
*/

package com.nebur.teide.tienda.modelo.viewforms;

import com.nebur.teide.tienda.modelo.TiendaCategoria;
import com.nebur.teide.tienda.modelo.TiendaProducto;

public class ProductoViewForm {
	private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String foto;
    private Integer existencias;
    private double precio;
    private Integer idCategoria;
    
    
	public ProductoViewForm() {
	}
	
	public ProductoViewForm(Integer idProducto, String nombre,
			String descripcion, String foto, Integer existencias,
			double precio, Integer idCategoria) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.existencias = existencias;
		this.precio = precio;
		this.idCategoria = idCategoria;
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
	}
}
