package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Produtora;

@Stateless
@LocalBean
public class ProdutoraBean {

	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Produtora cadastrar(Produtora produtora) throws Exception {
		manager.persist(produtora);
		manager.flush();
		return produtora;
	}
	
	public Produtora alterar(Produtora produtora) throws Exception {
		manager.find(Produtora.class, produtora.getId());
		manager.merge(produtora);
		manager.flush();
		return produtora;
	}
	
	public Produtora deletar(Produtora produtora) throws Exception {
		produtora = manager.find(Produtora.class, produtora.getId());
		manager.flush();
		return produtora;
	}
	
	public Produtora buscar(Long id) throws Exception {
		Produtora produtora = manager.find(Produtora.class, id);
		return produtora;
	}
}
