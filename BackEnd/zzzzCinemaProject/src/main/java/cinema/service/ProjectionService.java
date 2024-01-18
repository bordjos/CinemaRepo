package cinema.service;

import java.util.List;

import cinema.model.Projection;

public interface ProjectionService {

	Projection findOne(Long id);
	
	List<Projection> findAll();
	
	Projection save(Projection projection);
	
	Projection delete(Long id);
	
	List<Projection> findByFilmId(Long filmId);
}
