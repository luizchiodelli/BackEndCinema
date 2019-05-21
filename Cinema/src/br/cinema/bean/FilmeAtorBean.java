package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.FilmeAtor;

@Stateless
@LocalBean
public class FilmeAtorBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public FilmeAtor cadastrar(FilmeAtor filmeAtor) throws Exception {
		manager.persist(filmeAtor);
		manager.flush();
		return filmeAtor;
	}
	
	public FilmeAtor alterar(FilmeAtor filmeAtor) throws Exception {
		manager.find(FilmeAtor.class, filmeAtor.getId());
		manager.merge(filmeAtor);
		manager.flush();
		return filmeAtor;
	}
	
	public FilmeAtor deletar(FilmeAtor filmeAtor) throws Exception {
		filmeAtor = manager.find(FilmeAtor.class, filmeAtor.getId());
		manager.flush();
		return filmeAtor;
	}
	
	public FilmeAtor buscar(Long id) throws Exception {
		FilmeAtor filmeAtor = manager.find(FilmeAtor.class, id);
		return filmeAtor;
	}
}
