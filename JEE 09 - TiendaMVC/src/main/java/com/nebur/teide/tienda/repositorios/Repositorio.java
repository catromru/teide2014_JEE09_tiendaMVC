package com.nebur.teide.tienda.repositorios;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Repositorio<T> extends HibernateDaoSupport implements IRepositorio<T> {
	Session sesion;

	@Override
	public List<T> get(Class<T> tipoDato) {
		sesion = getSessionFactory().getCurrentSession();
		
		Query consulta = sesion.createQuery("from " + tipoDato.getName());
		
		List<T> lista = consulta.list();
		
		
		return lista;
	}

	@Override
	public T get(Class<T> tipoDato, Integer id) {
		sesion = getSessionFactory().getCurrentSession();
		
		T obj = (T) sesion.get(tipoDato, id);
		
		
		return obj;
	}

	@Override
	public void add(T objeto) {
		sesion = getSessionFactory().getCurrentSession();
		
		sesion.save(objeto);
	}

	@Override
	public void update(T objeto) {
		sesion = getSessionFactory().getCurrentSession();
		
		sesion.update(objeto);
	}

	@Override
	public void delete(T objeto) {
		sesion = getSessionFactory().getCurrentSession();
		
		sesion.delete(objeto);
	}

	@Override
	public List<T> find(String q, Map<String, Object> parametros) {
		sesion = getSessionFactory().getCurrentSession();
		
		Query consulta = sesion.getNamedQuery(q);
		
		for (String param : parametros.keySet()) {
			consulta.setParameter(param, parametros.get(param));
		}
		
		List<T> lista = consulta.list();
		
		
		return lista;
	}
	
}
