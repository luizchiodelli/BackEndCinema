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

import br.cinema.bean.TicketBean;
import br.cinema.model.Ticket;

@Path("ticket")
public class TicketRest {

	@EJB
	private TicketBean bean;
	
	@POST
	@Path("salvar")
	@Produces(MediaType.APPLICATION_JSON) //vai retornar JSON
	public Response salvar(Ticket ticket) {
		try {
			return Response.ok(bean.cadastrar(ticket)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Ticket ticket = bean.buscar(id);
			return Response.ok(ticket).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Ticket ticket) {
		try {
			ticket = bean.alterar(ticket);
			return Response.ok(ticket).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(Ticket ticket) {
		try {
			bean.deletar(ticket);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage()).build();
		}
	}
}
