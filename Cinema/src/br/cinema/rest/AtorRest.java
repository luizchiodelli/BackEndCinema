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

import br.cinema.bean.AtorBean;
import br.cinema.model.Ator;

@Path("ator")
public class AtorRest {

	@EJB
	private AtorBean bean;
	
	@POST
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) //vai retornar JSON
	public Response salvar(Ator ator) {
		try {
			return Response.ok(bean.cadastrar(ator)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Ator ator = bean.buscar(id);
			return Response.ok(ator).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Ator ator) {
		try {
			ator = bean.alterar(ator);
			return Response.ok(ator).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(Ator ator) {
		try {
			bean.deletar(ator);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
