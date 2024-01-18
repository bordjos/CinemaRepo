package cinema.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projection;
import cinema.service.AuditoriumService;
import cinema.service.FilmService;
import cinema.service.ProjectionService;
import cinema.web.dto.ProjectionDTO;

@Component
public class ProjectionDTOToProjection implements Converter<ProjectionDTO, Projection> {

	private final ProjectionService projectionService;
	private final FilmService filmService;
	private final AuditoriumService auditoriumService;

	public ProjectionDTOToProjection(ProjectionService projectionService, FilmService filmService,
			AuditoriumService auditoriumService) {
		super();
		this.projectionService = projectionService;
		this.filmService = filmService;
		this.auditoriumService = auditoriumService;
	}

	@Override
	public Projection convert(ProjectionDTO dto) {
		Projection projection = (dto.getId() == null) ? new Projection() : projectionService.findOne(dto.getId());

		if (projection != null) {
			projection.setDateTime(getLocalDateTime(dto.getDateTime()));
			projection.setPrice(dto.getPrice());
			projection.setFilm(filmService.findOne(dto.getFilmId()));
			projection.setAuditorium(auditoriumService.findOne(dto.getAuditoriumId()));
			
		}

		return projection;
	}
	
	public List<Projection> convert(List<ProjectionDTO> projectionsDTO) {
		return projectionsDTO.stream().map(this::convert).collect(Collectors.toList());
	}

	private LocalDateTime getLocalDateTime(String dateTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return LocalDateTime.parse(dateTime, dtf);
	}

}
