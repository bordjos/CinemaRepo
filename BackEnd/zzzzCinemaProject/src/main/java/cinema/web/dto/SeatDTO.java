package cinema.web.dto;

import javax.validation.constraints.Positive;

public class SeatDTO {

	@Positive(message = "ID must be a positive number!")
	private Long id;

	@Positive(message = "Seat number must be a positive value!")
	private int number;

	@Positive(message = "ID must be a positive number!")
	private Long auditoriumId;

	private Long ticketId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Long getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(Long auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

}
