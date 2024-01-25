package cinema.support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projection;
import cinema.model.Ticket;
import cinema.web.dto.ProjectionDTO;

@Component
public class ProjectionToProjectionDTO implements Converter<Projection, ProjectionDTO> {

	@Override
	public ProjectionDTO convert(Projection projection) {
		ProjectionDTO dto = new ProjectionDTO();

		dto.setId(projection.getId());
		dto.setDateTime(projection.getDateTime().toString());
		dto.setPrice(projection.getPrice());
		dto.setFilmId(projection.getFilm().getId());
		dto.setFilmName(projection.getFilm().getName());
		dto.setAuditoriumId(projection.getAuditorium().getId());
		dto.setProjectionTypeId(projection.getProjectionType().getId());
		
//		List<Long> ticketIds = new ArrayList<>();
//		for (Ticket ticket : projection.getTickets()) {
//			ticketIds.add(ticket.getId());
//		}
//		dto.setReservedTicketIds(ticketIds);
		
		List<Long> reservedSeatIds = new ArrayList<>();
		for(Ticket ticket : projection.getTickets()) {
			Long seatId = ticket.getSeat().getId();
			
			reservedSeatIds.add(seatId);
		}
		
		dto.setReservedSeatIds(reservedSeatIds);

		return dto;
	}

	public List<ProjectionDTO> convert(List<Projection> projections) {
		return projections.stream().map(this::convert).collect(Collectors.toList());
	}

}
