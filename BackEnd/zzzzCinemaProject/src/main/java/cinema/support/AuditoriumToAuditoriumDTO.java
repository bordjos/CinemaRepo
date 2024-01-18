package cinema.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Auditorium;
import cinema.web.dto.AuditoriumDTO;

@Component
public class AuditoriumToAuditoriumDTO implements Converter<Auditorium, AuditoriumDTO> {

	@Override
	public AuditoriumDTO convert(Auditorium auditorium) {
		AuditoriumDTO dto = new AuditoriumDTO();
		
		dto.setId(auditorium.getId());
		dto.setName(auditorium.getName());
		
		return dto;
	}
	
	public List<AuditoriumDTO> convert(List<Auditorium> auditoriums) {
		return auditoriums.stream().map(this::convert).collect(Collectors.toList());
	}

}
