package cinema.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.ProjectionType;
import cinema.web.dto.ProjectionTypeDTO;

@Component
public class ProjectionTypeToProjectionTypeDTO implements Converter<ProjectionType, ProjectionTypeDTO> {

	@Override
	public ProjectionTypeDTO convert(ProjectionType projectionType) {
		ProjectionTypeDTO dto = new ProjectionTypeDTO();

		dto.setId(projectionType.getId());
		dto.setType(projectionType.getType());
		dto.setAuditoriumId(projectionType.getAuditorium().getId());

		return dto;
	}
	
	public List<ProjectionTypeDTO> convert(List<ProjectionType> projectionTypes) {
		return projectionTypes.stream().map(this::convert).collect(Collectors.toList());
	}

}
