package cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.ProjectionType;

@Repository
public interface ProjectionTypeRepository extends JpaRepository<ProjectionType, Long> {

}
