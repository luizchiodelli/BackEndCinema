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

import br.cinema.bean.FilmeAtorBean;
import br.cinema.model.FilmeAtor;

@Path("filmeAtor")
public class FilmeAtorRest {

	@EJB
	private FilmeAtorBean bean;
	
	@POST 
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response salvar(FilmeAtor filmeAtor) {
		try {
			return Response.ok(bean.cadastrar(filmeAtor)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			FilmeAtor filmeAtor = bean.buscar(id);
			return Response.ok(filmeAtor).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(FilmeAtor filmeAtor) {
		try {
			filmeAtor = bean.alterar(filmeAtor);
			return Response.ok(filmeAtor).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(FilmeAtor filmeAtor) {
		try {
			bean.deletar(filmeAtor);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
