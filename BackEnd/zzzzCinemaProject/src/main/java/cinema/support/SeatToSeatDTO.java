package cinema.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Seat;
import cinema.web.dto.SeatDTO;

@Component
public class SeatToSeatDTO implements Converter<Seat, SeatDTO> {

	@Override
	public SeatDTO convert(Seat seat) {
		SeatDTO dto = new SeatDTO();

		dto.setId(seat.getId());
		dto.setNumber(seat.getNumber());
		dto.setAuditoriumId(seat.getAuditorium().getId());
		if (seat.getTicket() != null) {
			dto.setTicketId(seat.getTicket().getId());
		}

		return dto;
	}

	public List<SeatDTO> convert(List<Seat> seats) {
		return seats.stream().map(this::convert).collect(Collectors.toList());
	}
}
