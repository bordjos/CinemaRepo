package cinema.service;

import java.util.List;

import cinema.model.Auditorium;

public interface AuditoriumService {

	Auditorium findOne(Long id);
	
	List<Auditorium> findAll();
	
	Auditorium update(Auditorium auditorium);
}
