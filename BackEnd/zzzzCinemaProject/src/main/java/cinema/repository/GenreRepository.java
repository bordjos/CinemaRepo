package cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	List<Genre> findByIdIn(List<Long> ids);


}
