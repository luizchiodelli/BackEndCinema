package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.DiretorFilme;

@Stateless
@LocalBean
public class DiretorFilmeBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public DiretorFilme cadastrar(DiretorFilme diretorFilme) throws Exception {
		manager.persist(diretorFilme);
		manager.flush();
		return diretorFilme;
	}
	
	public DiretorFilme alterar(DiretorFilme diretorFilme) throws Exception {
		manager.find(DiretorFilme.class, diretorFilme.getId());
		manager.merge(diretorFilme);
		manager.flush();
		return diretorFilme;
	}
	
	public DiretorFilme deletar(DiretorFilme diretorFilme) throws Exception {
		diretorFilme = manager.find(DiretorFilme.class, diretorFilme.getId());
		manager.flush();
		return diretorFilme;
	}
	
	public DiretorFilme buscar(Long id) throws Exception {
		DiretorFilme diretorFilme = manager.find(DiretorFilme.class, id);
		return diretorFilme;
	}
}
