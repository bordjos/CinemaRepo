package cinema.web.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import cinema.model.Projection;

public class FilmDTO {

	@Positive(message = "ID must be a positive number!")
	private Long id;

	@NotBlank(message = "The name of the film is not set!")
	private String name;

	@NotBlank(message = "The director of the film is not set!")
	private String director;

	@NotBlank(message = "The cast of the film is not set!")
	private String cast;

	@NotNull(message = "The length of the film is not set!")
	@Positive(message = "The length of the film must be a positive number!")
	private int length;

	@NotBlank(message = "The distributor of the film is not set!")
	private String distributor;

	@NotBlank(message = "The distributor of the film is not set!")
	private String country;

	@Min(value = 1900, message = "The year must be equal to or greater than 1900")
	@Max(value = 2024, message = "The year must be less than or equal to 1900")
	private int year;

	@NotBlank(message = "The description of the film is not set!")
	private String about;

	@NotBlank(message = "The poster URL of the film is not set!")
	private String posterUrl;

	private Map<Long, String> genres = new LinkedHashMap<>();

	private List<ProjectionDTO> projectionsDTO = new ArrayList<>();

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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public Map<Long, String> getGenres() {
		return genres;
	}

	public void setGenres(Map<Long, String> genres) {
		this.genres = genres;
	}

	public List<ProjectionDTO> getProjectionsDTO() {
		return projectionsDTO;
	}

	public void setProjectionsDTO(List<ProjectionDTO> projectionsDTO) {
		this.projectionsDTO = projectionsDTO;
	}

}
