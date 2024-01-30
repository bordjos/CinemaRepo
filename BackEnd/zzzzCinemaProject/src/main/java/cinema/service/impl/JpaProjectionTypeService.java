package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.ProjectionType;
import cinema.repository.ProjectionTypeRepository;
import cinema.service.ProjectionTypeService;

@Service
public class JpaProjectionTypeService implements ProjectionTypeService {

	@Autowired
	private ProjectionTypeRepository projectionTypeRepository;

	@Override
	public ProjectionType findOne(Long id) {
		return projectionTypeRepository.findById(id).orElse(null);
	}

	@Override
	public List<ProjectionType> findAll() {
		return projectionTypeRepository.findAll();
	}
}
