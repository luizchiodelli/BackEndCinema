package br.cinema.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.cinema.bean.UsuarioBean;
import br.cinema.model.Usuario;

@Path("usuario")
public class UsuarioRest {

	@EJB
	private UsuarioBean usuarioBean;
	
	@POST
	@Path("logar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logar(Usuario usuario) {
		try {
			usuario = usuarioBean.logar(usuario.getEmail(), usuario.getSenha());
			return Response.ok(usuario).build();
		}catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@EJB
	private UsuarioBean bean;
	
	@POST 
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response salvar(Usuario usuario) {
		try {
			return Response.ok(bean.cadastrar(usuario)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Usuario usuario = bean.buscar(id);
			return Response.ok(usuario).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Usuario usuario) {
		try {
			usuario = bean.alterar(usuario);
			return Response.ok(usuario).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(Usuario usuario) {
		try {
			bean.deletar(usuario);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
