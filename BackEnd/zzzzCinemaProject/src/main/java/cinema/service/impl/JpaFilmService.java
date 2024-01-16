package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Film;
import cinema.repository.FilmRepository;
import cinema.service.FilmService;

@Service
public class JpaFilmService implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	@Override
	public Film findOne(Long id) {
		return filmRepository.findById(id).orElse(null);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

	@Override
	public Film save(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public Film delete(Long id) {
		Film film = findOne(id);
		if (film != null) {
			filmRepository.delete(film);
		}

		return film;
	}

	@Override
	public List<Film> findByGenreId(Long genreId) {
		return filmRepository.findByGenresId(genreId);
	}

}
