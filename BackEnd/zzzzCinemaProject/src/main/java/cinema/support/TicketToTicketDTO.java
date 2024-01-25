package cinema.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Ticket;
import cinema.web.dto.TicketDTO;

@Component
public class TicketToTicketDTO implements Converter<Ticket, TicketDTO> {

	@Override
	public TicketDTO convert(Ticket ticket) {
		TicketDTO dto = new TicketDTO();

		dto.setId(ticket.getId());
		dto.setSeatId(ticket.getSeat().getId());
		dto.setProjectionId(ticket.getProjection().getId());
		dto.setSaleDateTime(ticket.getSaleDateTime().toString());

		return dto;
	}

	public List<TicketDTO> convert(List<Ticket> tickets) {
		return tickets.stream().map(this::convert).collect(Collectors.toList());
	}

}
