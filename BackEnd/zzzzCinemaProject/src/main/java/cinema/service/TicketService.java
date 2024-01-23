package cinema.service;

import java.util.List;

import cinema.model.Ticket;

public interface TicketService {

	Ticket findOne(Long id);
	
	List<Ticket> findAll();
	
	Ticket save(Ticket ticket);
	
	Ticket delete(Long id);
}
