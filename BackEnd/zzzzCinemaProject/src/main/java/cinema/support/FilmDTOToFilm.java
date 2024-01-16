package cinema.support;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Film;
import cinema.service.FilmService;
import cinema.service.GenreService;
import cinema.web.dto.FilmDTO;

@Component
public class FilmDTOToFilm implements Converter<FilmDTO, Film> {

	private final FilmService filmService;
	private final GenreService genreService;
	
	
	@Autowired
	public FilmDTOToFilm(FilmService filmService, GenreService genreService) {
		super();
		this.filmService = filmService;
		this.genreService = genreService;
	}


	@Override
	public Film convert(FilmDTO dto) {
		Film film = (dto.getId() == null) ? new Film() : filmService.findOne(dto.getId());
		
		if(film != null) {
			film.setName(dto.getName());
			film.setDirector(dto.getDirector());
			film.setCast(dto.getCast());
			film.setLength(dto.getLength());
			film.setDistributor(dto.getDistributor());
			film.setDirector(dto.getCountry());
			film.setYear(dto.getYear());
			film.setAbout(dto.getAbout());
			film.setPosterUrl(dto.getPosterUrl());
						
													//go through each key and call a findOne() method on it
			film.setGenres(dto.getGenres().keySet().stream().map(genreService::findOne).collect(Collectors.toSet())); 
		}
		
		return film;
	}
	
	
	
}
