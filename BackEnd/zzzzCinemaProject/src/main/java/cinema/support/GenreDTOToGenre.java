package cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Genre;
import cinema.service.GenreService;
import cinema.web.dto.GenreDTO;

@Component
public class GenreDTOToGenre implements Converter<GenreDTO, Genre> {

	// using Constructor Injection - the dependencies can be final, which helps with
	// robustness and thread-safety //dependencies are clearly identified
	private final GenreService genreService;

	@Autowired
	public GenreDTOToGenre(GenreService genreService) {
		super();
		this.genreService = genreService;
	}

	@Override
	public Genre convert(GenreDTO dto) {
		Genre genre = (dto.getId() == null) ? new Genre() : genreService.findOne(dto.getId());

		if (genre != null) {
			genre.setName(dto.getName());
		}

		return genre;
	}

}
