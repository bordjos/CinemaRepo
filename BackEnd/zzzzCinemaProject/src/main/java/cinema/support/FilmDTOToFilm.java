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
	private final ProjectionDTOToProjection toProjection;
	
//	@Autowired
//	public FilmDTOToFilm(FilmService filmService, GenreService genreService) {
//		super();
//		this.filmService = filmService;
//		this.genreService = genreService;
//	}
	
	
	public FilmDTOToFilm(FilmService filmService, GenreService genreService, ProjectionDTOToProjection toProjection) {
		super();
		this.filmService = filmService;
		this.genreService = genreService;
		this.toProjection = toProjection;
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
			film.setCountry(dto.getCountry());
			film.setDirector(dto.getCountry());
			film.setYear(dto.getYear());
			film.setAbout(dto.getAbout());
			film.setPosterUrl(dto.getPosterUrl());
			film.setProjections(toProjection.convert(dto.getProjectionsDTO()));
						
													//go through each key and call a findOne() method on it
			film.setGenres(dto.getGenres().keySet().stream().map(genreService::findOne).collect(Collectors.toSet())); 
		}
		
		return film;
	}

	
	
	
}
