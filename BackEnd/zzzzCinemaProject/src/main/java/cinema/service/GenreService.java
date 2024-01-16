package cinema.service;

import java.util.List;

import cinema.model.Genre;

public interface GenreService {

	Genre findOne(Long id);
	
	List<Genre> find(List<Long> ids);
	
	Genre save(Genre genre);
	
	Genre delete(Long id);
	
	
}
