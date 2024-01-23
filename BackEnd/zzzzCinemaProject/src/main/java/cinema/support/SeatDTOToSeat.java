package cinema.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Seat;
import cinema.service.AuditoriumService;
import cinema.service.SeatService;
import cinema.service.TicketService;
import cinema.web.dto.SeatDTO;

@Component
public class SeatDTOToSeat implements Converter<SeatDTO, Seat> {

	private final SeatService seatService;
	private final AuditoriumService auditoriumService;
	private final TicketService ticketService;

	

	public SeatDTOToSeat(SeatService seatService, AuditoriumService auditoriumService, TicketService ticketService) {
		super();
		this.seatService = seatService;
		this.auditoriumService = auditoriumService;
		this.ticketService = ticketService;
	}



	@Override
	public Seat convert(SeatDTO dto) {
		Seat seat = seatService.findOne(dto.getId());
		
		if(seat != null) {
			seat.setNumber(dto.getNumber());
			seat.setAuditorium(auditoriumService.findOne(dto.getAuditoriumId()));
			seat.setTicket(ticketService.findOne(dto.getTicketId()));
		}
		
		return seat;
	}

}
