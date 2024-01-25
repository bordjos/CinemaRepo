package cinema.web.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class ProjectionDTO {

	@Positive(message = "ID must be a positive number!")
	private Long id;

	@NotBlank(message = "Date and time are not set!")
	@Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]$", message = "Date and time are not valid!")
	private String dateTime;

	@Positive(message = "Price must be a positive number!")
	private double price;

	@Positive(message = "ID must be a positive number!")
	@NotNull
	private Long filmId;

	private String filmName;

	@Positive(message = "ID must be a positive number!")
	@NotNull
	private Long auditoriumId;

	@Positive(message = "ID must be a positive number!")
	private Long projectionTypeId;

//	List<Long> reservedTicketIds;

	List<Long> reservedSeatIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(Long auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	public Long getProjectionTypeId() {
		return projectionTypeId;
	}

	public void setProjectionTypeId(Long projectionTypeId) {
		this.projectionTypeId = projectionTypeId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public List<Long> getReservedSeatIds() {
		return reservedSeatIds;
	}

	public void setReservedSeatIds(List<Long> reservedSeatIds) {
		this.reservedSeatIds = reservedSeatIds;
	}

//	public List<Long> getReservedTicketIds() {
//		return reservedTicketIds;
//	}
//
//	public void setReservedTicketIds(List<Long> reservedTicketIds) {
//		this.reservedTicketIds = reservedTicketIds;
//	}

}
