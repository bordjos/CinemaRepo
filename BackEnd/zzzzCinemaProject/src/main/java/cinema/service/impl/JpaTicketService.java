package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Ticket;
import cinema.repository.TicketRepository;
import cinema.service.TicketService;

@Service
public class JpaTicketService implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Ticket findOne(Long id) {
		return ticketRepository.findById(id).orElse(null);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket save(Ticket ticket) {
		
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket delete(Long id) {
		Ticket ticket = findOne(id);
		
		if(ticket != null) {
			ticket.getProjection().getTickets().remove(ticket);
			
			ticketRepository.delete(ticket);
		}
		
		return ticket;
	}

}
