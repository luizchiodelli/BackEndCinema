package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Diretor;

@Stateless
@LocalBean
public class DiretorBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Diretor cadastrar(Diretor diretor) throws Exception {
		manager.persist(diretor);
		manager.flush();
		return diretor;
	}
	
	public Diretor alterar(Diretor diretor) throws Exception {
		manager.find(Diretor.class, diretor.getId());
		manager.merge(diretor);
		manager.flush();
		return diretor;
	}
	
	public Diretor deletar(Diretor diretor) throws Exception {
		diretor = manager.find(Diretor.class, diretor.getId());
		manager.flush();
		return diretor;
	}
	
	public Diretor buscar(Long id) throws Exception {
		Diretor diretor = manager.find(Diretor.class, id);
		return diretor;
	}
}
