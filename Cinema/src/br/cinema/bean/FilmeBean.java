package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Filme;

@Stateless
@LocalBean
public class FilmeBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Filme cadastrar(Filme filme) throws Exception {
		manager.persist(filme);
		manager.flush();
		return filme;
	}
	
	public Filme alterar(Filme filme) throws Exception {
		manager.find(Filme.class, filme.getId());
		manager.merge(filme);
		manager.flush();
		return filme;
	}
	
	public Filme deletar(Filme filme) throws Exception {
		filme = manager.find(Filme.class, filme.getId());
		manager.flush();
		return filme;
	}
	
	public Filme buscar(Long id) throws Exception {
		Filme filme = manager.find(Filme.class, id);
		return filme;
	}
}
