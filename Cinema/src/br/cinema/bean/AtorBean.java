package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Ator;

@Stateless
@LocalBean
public class AtorBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Ator cadastrar(Ator ator) throws Exception {
		manager.persist(ator);
		manager.flush();
		return ator;
	}
	
	public Ator alterar(Ator ator) throws Exception {
		manager.find(Ator.class, ator.getId());
		manager.merge(ator);
		manager.flush();
		return ator;
	}
	
	public Ator deletar(Ator ator) throws Exception {
		ator = manager.find(Ator.class, ator.getId());
		manager.flush();
		return ator;
	}
	
	public Ator buscar(Long id) throws Exception {
		Ator ator = manager.find(Ator.class, id);
		return ator;
	}
}
