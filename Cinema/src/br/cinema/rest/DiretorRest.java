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

import br.cinema.bean.DiretorBean;
import br.cinema.model.Diretor;

@Path("diretor")
public class DiretorRest {

	@EJB
	private DiretorBean bean;
	
	@POST 
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response salvar(Diretor diretor) {
		try {
			return Response.ok(bean.cadastrar(diretor)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Diretor diretor = bean.buscar(id);
			return Response.ok(diretor).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Diretor diretor) {
		try {
			diretor = bean.alterar(diretor);
			return Response.ok(diretor).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(Diretor diretor) {
		try {
			bean.deletar(diretor);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
