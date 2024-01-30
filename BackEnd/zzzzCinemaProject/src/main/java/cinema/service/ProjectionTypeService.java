package cinema.service;

import java.util.List;

import cinema.model.ProjectionType;

public interface ProjectionTypeService {

	ProjectionType findOne(Long id);

	List<ProjectionType> findAll();

}
