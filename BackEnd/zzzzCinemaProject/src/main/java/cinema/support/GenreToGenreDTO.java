package cinema.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Genre;
import cinema.web.dto.GenreDTO;

@Component
public class GenreToGenreDTO implements Converter<Genre, GenreDTO> {

	@Override
	public GenreDTO convert(Genre genre) {
		GenreDTO dto = new GenreDTO();

		dto.setId(genre.getId());
		dto.setName(genre.getName());

		return dto;
	}

	public List<GenreDTO> convert(List<Genre> genres) {
		return genres.stream().map(this::convert).collect(Collectors.toList());

	}

}
