package cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class AuditoriumDTO {

	@Positive(message = "ID must be a positive number!")
	private Long id;

	@NotBlank(message = "The name of the auditorium is not set!")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
