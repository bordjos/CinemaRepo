package cinema.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Projection;
import cinema.service.ProjectionService;
import cinema.support.ProjectionDTOToProjection;
import cinema.support.ProjectionToProjectionDTO;
import cinema.web.dto.ProjectionDTO;

@RestController
@RequestMapping(value = "/api/projections", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectionController {

	@Autowired
	private ProjectionService projectionService;

	@Autowired
	private ProjectionToProjectionDTO toProjectionDTO;

	@Autowired
	private ProjectionDTOToProjection toProjection;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectionDTO> create(@Valid @RequestBody ProjectionDTO projectionDTO) {

		Projection projection = toProjection.convert(projectionDTO);

		if (projection.getFilm() == null || projection.getProjectionType() == null
				|| projection.getAuditorium() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toProjectionDTO.convert(projectionService.save(projection)), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectionDTO> update(@PathVariable Long id,
			@Valid @RequestBody ProjectionDTO projectionDTO) {

		if (!id.equals(projectionDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Projection projection = toProjection.convert(projectionDTO);

		if (projection.getFilm() == null || projection.getProjectionType() == null
				|| projection.getAuditorium() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toProjectionDTO.convert(projectionService.save(projection)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Projection projection = projectionService.delete(id);

		if (projection != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectionDTO> getOne(@PathVariable Long id) {
		Projection projection = projectionService.findOne(id);

		if (projection != null) {
			return new ResponseEntity<>(toProjectionDTO.convert(projection), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<ProjectionDTO>> getAll() {

		List<Projection> projections = projectionService.findAll();

		return new ResponseEntity<>(toProjectionDTO.convert(projections), HttpStatus.OK);

	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
