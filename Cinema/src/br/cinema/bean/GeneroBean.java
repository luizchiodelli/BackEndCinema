package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Genero;

@Stateless
@LocalBean
public class GeneroBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Genero cadastrar(Genero genero) throws Exception {
		manager.persist(genero);
		manager.flush();
		return genero;
	}
	
	public Genero alterar(Genero genero) throws Exception {
		manager.find(Genero.class, genero.getId());
		manager.merge(genero);
		manager.flush();
		return genero;
	}
	
	public Genero deletar(Genero genero) throws Exception {
		genero = manager.find(Genero.class, genero.getId());
		manager.flush();
		return genero;
	}
	
	public Genero buscar(Long id) throws Exception {
		Genero genero = manager.find(Genero.class, id);
		return genero;
	}
}
