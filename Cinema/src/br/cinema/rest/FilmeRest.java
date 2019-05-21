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

import br.cinema.bean.FilmeBean;
import br.cinema.model.Filme;

@Path("filme")
public class FilmeRest {

	@EJB
	private FilmeBean bean;
	
	@POST 
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response salvar(Filme filme) {
		try {
			return Response.ok(bean.cadastrar(filme)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Filme filme = bean.buscar(id);
			return Response.ok(filme).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Filme filme) {
		try {
			filme = bean.alterar(filme);
			return Response.ok(filme).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(Filme filme) {
		try {
			bean.deletar(filme);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
