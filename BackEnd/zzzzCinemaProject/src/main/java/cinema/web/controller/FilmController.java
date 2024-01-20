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

import cinema.model.Film;
import cinema.service.FilmService;
import cinema.support.FilmDTOToFilm;
import cinema.support.FilmToFilmDTO;
import cinema.web.dto.FilmDTO;

@RestController
@RequestMapping(value = "/api/films", produces = MediaType.APPLICATION_JSON_VALUE)
public class FilmController {

//	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//	@PreAuthorize("hasAuthority('ADMIN')")

	@Autowired
	private FilmService filmService;

	@Autowired
	private FilmDTOToFilm toFilm;

	@Autowired
	private FilmToFilmDTO toFilmDTO;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO) {

		Film film = toFilm.convert(filmDTO);

		return new ResponseEntity<FilmDTO>(toFilmDTO.convert(filmService.save(film)), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FilmDTO> update(@PathVariable Long id, @Valid @RequestBody FilmDTO filmDTO) {

		System.out.println("OVO JE TO: " + filmDTO);
		
		if (!id.equals(filmDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Film film = toFilm.convert(filmDTO);

		return new ResponseEntity<FilmDTO>(toFilmDTO.convert(filmService.save(film)), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		Film film = filmService.delete(id);

		if (film != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FilmDTO> getOne(@PathVariable Long id) {

		Film film = filmService.findOne(id);

		if (film != null) {
			return new ResponseEntity<>(toFilmDTO.convert(film), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<FilmDTO>> getAll() {

		List<Film> films = filmService.findAll();

		return new ResponseEntity<>(toFilmDTO.convert(films), HttpStatus.OK);

	}

	// TODO 
//	@GetMapping("/{id}/projections")
//	public ResponseEntity<List<ProjectionDTO>> getByFilmId(@PathVariable Long id) {
//		List<Projection> projections = projectionService.findByFilmId(id);
//
//		return new ResponseEntity<>(toProjectionDTO.convert(projections), HttpStatus.OK);
//	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

}
