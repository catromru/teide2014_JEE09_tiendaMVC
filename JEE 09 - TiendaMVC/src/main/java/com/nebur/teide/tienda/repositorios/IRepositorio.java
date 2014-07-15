package com.nebur.teide.tienda.repositorios;

import java.util.List;
import java.util.Map;

public interface IRepositorio<T> {
	public List<T> get(Class<T> tipoDato);
	public T get(Class<T> tipoDato, Integer id);
	public void add(T objeto);
	public void update(T objeto);
	public void delete(T objeto);
	public List<T> find(String q, Map<String, Object> parametros);
}
