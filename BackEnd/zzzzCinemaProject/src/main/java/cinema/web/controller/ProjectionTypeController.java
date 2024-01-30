package cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.ProjectionType;
import cinema.service.ProjectionTypeService;
import cinema.support.ProjectionTypeToProjectionTypeDTO;
import cinema.web.dto.ProjectionTypeDTO;

@RestController
@RequestMapping(value = "/api/projection-types", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectionTypeController {

	@Autowired
	private ProjectionTypeService projectionTypeService;

	@Autowired
	ProjectionTypeToProjectionTypeDTO toProjectionTypeDTO;

	@GetMapping("/{id}")
	public ResponseEntity<ProjectionTypeDTO> getOne(@PathVariable Long id) {
		ProjectionType projectionType = projectionTypeService.findOne(id);

		if (projectionTypeService != null) {
			return new ResponseEntity<>(toProjectionTypeDTO.convert(projectionType), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<ProjectionTypeDTO>> getAll() {

		List<ProjectionType> projectionTypes = projectionTypeService.findAll();

		return new ResponseEntity<>(toProjectionTypeDTO.convert(projectionTypes), HttpStatus.OK);

	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
