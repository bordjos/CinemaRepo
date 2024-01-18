package cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {

	List<Projection> findByFilmId(Long filmId);

}
