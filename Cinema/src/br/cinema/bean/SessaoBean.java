package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Sessao;

@Stateless
@LocalBean
public class SessaoBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Sessao cadastrar(Sessao sessao) throws Exception {
		manager.persist(sessao);
		manager.flush();
		return sessao;
	}
	
	public Sessao alterar(Sessao sessao) throws Exception {
		manager.find(Sessao.class, sessao.getId());
		manager.merge(sessao);
		manager.flush();
		return sessao;
	}
	
	public Sessao deletar(Sessao sessao) throws Exception {
		sessao = manager.find(Sessao.class, sessao.getId());
		manager.flush();
		return sessao;
	}
	
	public Sessao buscar(Long id) throws Exception {
		Sessao sessao = manager.find(Sessao.class, id);
		return sessao;
	}
}
