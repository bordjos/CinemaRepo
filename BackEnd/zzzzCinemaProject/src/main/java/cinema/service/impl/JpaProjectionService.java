package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Projection;
import cinema.repository.ProjectionRepository;
import cinema.service.ProjectionService;

@Service
public class JpaProjectionService implements ProjectionService {

	@Autowired
	private ProjectionRepository projectionRepository;

	@Override
	public Projection findOne(Long id) {
		return projectionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Projection> findAll() {
		return projectionRepository.findAll();
	}

	@Override
	public Projection save(Projection projection) {
		return projectionRepository.save(projection);
	}

	@Override
	public Projection delete(Long id) {
		Projection projection = findOne(id);

		if (projection != null) {
			projection.getFilm().getProjections().remove(projection);
			projection.getAuditorium().getProjections().remove(projection);
			projection.getProjectionType().getProjections().remove(projection);
			projectionRepository.delete(projection);
		}

		return projection;
	}

	@Override
	public List<Projection> findByFilmId(Long filmId) {
		return projectionRepository.findByFilmId(filmId);
	}

}
