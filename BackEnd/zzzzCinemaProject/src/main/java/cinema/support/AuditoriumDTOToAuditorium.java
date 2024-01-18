package cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Auditorium;
import cinema.service.AuditoriumService;
import cinema.web.dto.AuditoriumDTO;

@Component
public class AuditoriumDTOToAuditorium implements Converter<AuditoriumDTO, Auditorium>{

	@Autowired
	private AuditoriumService auditoriumService;
	
	@Override
	public Auditorium convert(AuditoriumDTO dto) {
		Auditorium auditorium = (dto.getId() == null) ? new Auditorium() : auditoriumService.findOne(dto.getId());
		
		if(auditorium != null) {
			auditorium.setName(dto.getName());
		}
		
		return auditorium;
	}

}
