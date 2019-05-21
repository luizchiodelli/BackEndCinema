package br.cinema.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.cinema.model.Usuario;

@Stateless
@LocalBean
public class UsuarioBean {
	
	@PersistenceContext(unitName="Cinema")
	protected EntityManager manager;
	
	public Usuario cadastrar(Usuario usuario) throws Exception {
		manager.persist(usuario);
		manager.flush();
		return usuario;
	}
	
	public Usuario alterar(Usuario usuario) throws Exception {
		manager.find(Usuario.class, usuario.getId());
		manager.merge(usuario);
		manager.flush();
		return usuario;
	}
	
	public Usuario deletar(Usuario usuario) throws Exception {
		usuario = manager.find(Usuario.class, usuario.getId());
		manager.flush();
		return usuario;
	}
	
	public Usuario buscar(Long id) throws Exception {
		Usuario usuario = manager.find(Usuario.class, id);
		return usuario;
	}
	
	public Usuario logar(String email, String senha) throws Exception {
		String sql = "Select u from Usuario u where u.email = :email and u.senha = :senha";
		Query query = manager.createQuery(sql, Usuario.class);
		query.setParameter("email", email.toUpperCase());
		query.setParameter("senha", senha);
		List<Usuario> usuarios = query.getResultList();
		if (usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}

}
