package cinema.support;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Ticket;
import cinema.service.ProjectionService;
import cinema.service.SeatService;
import cinema.service.TicketService;
import cinema.web.dto.TicketDTO;

@Component
public class TicketDTOToTicket implements Converter<TicketDTO, Ticket> {

	private final TicketService ticketService;
	private final SeatService seatService;
	private final ProjectionService projectionService;

	public TicketDTOToTicket(TicketService ticketService, SeatService seatService,
			ProjectionService projectionService) {
		super();
		this.ticketService = ticketService;
		this.seatService = seatService;
		this.projectionService = projectionService;
	}

	public Ticket convert(TicketDTO dto) {
		Ticket ticket = (dto.getId() == null) ? new Ticket() : ticketService.findOne(dto.getId());

		if (ticket != null) {
			ticket.setSeat(seatService.findOne(dto.getSeatId()));
			ticket.setProjection(projectionService.findOne(dto.getProjectionId()));
			ticket.setSaleDateTime(LocalDateTime.now());
		}

		return ticket;
	}

//	@Override
//	public List<Ticket> convert(List<TicketDTO> ticketsDTO) {
//		return ticketsDTO.stream().map(this::convert).collect(Collectors.toList());
//	}

}

//@Component
//public class TicketDTOToTicket implements Converter<TicketDTO, Ticket> {
//
//	private final TicketService ticketService;
//	private final SeatService seatService;
//	private final ProjectionService projectionService;
//
//	public TicketDTOToTicket(TicketService ticketService, SeatService seatService,
//			ProjectionService projectionService) {
//		super();
//		this.ticketService = ticketService;
//		this.seatService = seatService;
//		this.projectionService = projectionService;
//	}
//
//	@Override
//	public Ticket convert(TicketDTO dto) {
//		Ticket ticket = (dto.getId() == null) ? new Ticket() : ticketService.findOne(dto.getId());
//
//		if (ticket != null) {
//			ticket.setSeat(seatService.findOne(dto.getSeatId()));
//			ticket.setProjection(projectionService.findOne(dto.getProjectionId()));
//			ticket.setSaleDateTime(LocalDateTime.now());
//
//		}
//
//		return ticket;
//	}
//
//}
