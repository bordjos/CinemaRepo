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
import cinema.model.Genre;
import cinema.service.FilmService;
import cinema.service.GenreService;
import cinema.support.FilmToFilmDTO;
import cinema.support.GenreDTOToGenre;
import cinema.support.GenreToGenreDTO;
import cinema.web.dto.FilmDTO;
import cinema.web.dto.GenreDTO;

@RestController
@RequestMapping(value = "/api/genres", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenreController {

	@Autowired
	private GenreService genreService;

	@Autowired
	private FilmService filmService;

	@Autowired
	private GenreDTOToGenre toGenre;

	@Autowired
	private GenreToGenreDTO toGenreDTO;

	@Autowired
	private FilmToFilmDTO toFilmDTO;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDTO> create(@Valid @RequestBody GenreDTO genreDTO) {
		Genre genre = toGenre.convert(genreDTO);

		return new ResponseEntity<>(toGenreDTO.convert(genreService.save(genre)), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDTO> update(@PathVariable Long id, @Valid @RequestBody GenreDTO genreDTO) {

		if (!id.equals(genreDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Genre genre = toGenre.convert(genreDTO);

		return new ResponseEntity<>(toGenreDTO.convert(genreService.save(genre)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Genre genre = genreService.delete(id);

        if(genre != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getOne(@PathVariable Long id){
        Genre genre = genreService.findOne(id);

        if(genre != null) {
            return new ResponseEntity<>(toGenreDTO.convert(genre), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/{id}/filmovi")
    public ResponseEntity<List<FilmDTO>> getByGenreId(@PathVariable Long id){
        List<Film> films = filmService.findByGenreId(id);

        return new ResponseEntity<>(toFilmDTO.convert(films), HttpStatus.OK);
    }
	
	//the user will get a BAD_REQUEST message if the DataIntegrityViolationException occurs
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

}
