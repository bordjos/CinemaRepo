package cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

	List<Film> findByGenresId(Long genreId);

	
}
