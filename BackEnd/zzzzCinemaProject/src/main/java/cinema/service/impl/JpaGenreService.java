package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Genre;
import cinema.repository.GenreRepository;
import cinema.service.GenreService;

@Service
public class JpaGenreService implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Genre findOne(Long id) {
		return genreRepository.findById(id).orElse(null);
	}

	@Override
	public List<Genre> find(List<Long> ids) {
		return genreRepository.findByIdIn(ids);
	}

	@Override
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public Genre delete(Long id) {
		Genre genre = findOne(id);
		if (genre != null) {
			genreRepository.delete(genre);
		}

		return genre;
	}

}
