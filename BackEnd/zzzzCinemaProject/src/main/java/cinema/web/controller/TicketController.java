package cinema.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Ticket;
import cinema.service.TicketService;
import cinema.support.TicketDTOToTicket;
import cinema.support.TicketToTicketDTO;
import cinema.web.dto.TicketDTO;

@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

//	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//	@PreAuthorize("hasAuthority('ADMIN')")

	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketDTOToTicket toTicket;

	@Autowired
	private TicketToTicketDTO toTicketDTO;

//	@PreAuthorize("hasAuthority('ADMIN')")
//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<TicketDTO> create(@Valid @RequestBody TicketDTO ticketDTO) {
//
//		
//		Ticket ticket = toTicket.convert(ticketDTO);
//
//		if (ticket.getProjection() == null || ticket.getSeat() == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<TicketDTO>(toTicketDTO.convert(ticketService.save(ticket)), HttpStatus.CREATED);
//	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TicketDTO>> create(@Valid @RequestBody List<TicketDTO> ticketsDTO) {

		List<Ticket> tickets = new ArrayList<>();

		for (TicketDTO ticketDTO : ticketsDTO) {
			Ticket ticket = toTicket.convert(ticketDTO);

			if (ticket.getProjection() == null || ticket.getSeat() == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			Ticket saved = ticketService.save(ticket);
			tickets.add(saved);
		}

		

		return new ResponseEntity<List<TicketDTO>>(toTicketDTO.convert(tickets), HttpStatus.CREATED);
	}

//	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> update(@PathVariable Long id, @Valid @RequestBody TicketDTO ticketDTO) {

		if (!id.equals(ticketDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Ticket ticket = toTicket.convert(ticketDTO);

		if (ticket.getProjection() == null || ticket.getSeat() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<TicketDTO>(toTicketDTO.convert(ticketService.save(ticket)), HttpStatus.OK);

	}

//	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		Ticket ticket = ticketService.delete(id);

		if (ticket != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping(value = "/{id}")
	public ResponseEntity<TicketDTO> getOne(@PathVariable Long id) {

		Ticket ticket = ticketService.findOne(id);

		if (ticket != null) {
			return new ResponseEntity<>(toTicketDTO.convert(ticket), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<TicketDTO>> getAll() {

		List<Ticket> tickets = ticketService.findAll();

		return new ResponseEntity<>(toTicketDTO.convert(tickets), HttpStatus.OK);

	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
