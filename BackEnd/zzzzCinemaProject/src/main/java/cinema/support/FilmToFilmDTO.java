package cinema.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Film;
import cinema.model.Genre;
import cinema.web.dto.FilmDTO;

@Component
public class FilmToFilmDTO implements Converter<Film, FilmDTO> {

	@Override
	public FilmDTO convert(Film film) {
		FilmDTO dto = new FilmDTO();

		dto.setId(film.getId());
		dto.setDirector(film.getDirector());
		dto.setCast(film.getCast());
		dto.setLength(film.getLength());
		dto.setDistributor(film.getDistributor());
		dto.setDirector(film.getCountry());
		dto.setYear(film.getYear());
		dto.setAbout(film.getAbout());
		dto.setPosterUrl(film.getPosterUrl());
		dto.setGenres(film.getGenres().stream().collect(Collectors.toMap(Genre::getId, Genre::getName)));

		return dto;
	}

	public List<FilmDTO> convert(List<Film> films) {
		return films.stream().map(this::convert).collect(Collectors.toList());
	}
}
