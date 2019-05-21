package br.cinema.rest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.cinema.bean.SessaoBean;
import br.cinema.model.Sessao;

@Path("sessao")
public class SessaoRest {

	@EJB
	private SessaoBean bean;
	
	@POST 
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response salvar(Sessao sessao) {
		try {
			return Response.ok(bean.cadastrar(sessao)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Sessao sessao = bean.buscar(id);
			return Response.ok(sessao).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Sessao sessao) {
		try {
			sessao = bean.alterar(sessao);
			return Response.ok(sessao).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(Sessao sessao) {
		try {
			bean.deletar(sessao);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
