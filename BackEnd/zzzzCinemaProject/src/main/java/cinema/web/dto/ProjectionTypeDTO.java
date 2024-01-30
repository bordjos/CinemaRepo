package cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProjectionTypeDTO {

	@Positive(message = "ID must be a positive number!")
	private Long id;

	@NotBlank(message = "Projection type is not set!")
	private String type;

	@Positive(message = "ID must be a positive number!")
	@NotNull
	private Long auditoriumId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(Long auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

}
