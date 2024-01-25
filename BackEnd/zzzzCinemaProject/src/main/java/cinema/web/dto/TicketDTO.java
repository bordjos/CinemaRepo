package cinema.web.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class TicketDTO {

	@Positive(message = "ID must be a positive number!")
	private Long id;

	@Positive(message = "ID must be a positive number!")
	@NotNull
	private Long projectionId;

//	@Positive(message = "ID must be a positive number!")
//	@NotNull
	private Long seatId;

	//create a custom annotation?
//	private List<Long> seatIds;

//	@Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]$", message = "Date and time are not valid!")
	private String saleDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(Long projectionId) {
		this.projectionId = projectionId;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getSaleDateTime() {
		return saleDateTime;
	}

//	public List<Long> getSeatIds() {
//		return seatIds;
//	}
//
//	public void setSeatIds(List<Long> seatIds) {
//		this.seatIds = seatIds;
//	}

	public void setSaleDateTime(String saleDateTime) {
		this.saleDateTime = saleDateTime;
	}

}
