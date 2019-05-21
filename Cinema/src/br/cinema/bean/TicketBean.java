package br.cinema.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cinema.model.Ticket;

@Stateless
@LocalBean
public class TicketBean {

	@PersistenceContext(unitName="Cinema")
	private EntityManager manager;
	
	public Ticket cadastrar(Ticket ticket) throws Exception {
		manager.persist(ticket);
		manager.flush();
		return ticket;
	}
	
	public Ticket alterar(Ticket ticket) throws Exception {
		manager.find(Ticket.class, ticket.getId());
		manager.merge(ticket);
		manager.flush();
		return ticket;
	}
	
	public Ticket deletar(Ticket ticket) throws Exception {
		ticket = manager.find(Ticket.class, ticket.getId());
		manager.flush();
		return ticket;
	}
	
	public Ticket buscar(Long id) throws Exception {
		Ticket ticket = manager.find(Ticket.class, id);
		return ticket;
	}
}
