package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Auditorium;
import cinema.repository.AuditoriumRepository;
import cinema.service.AuditoriumService;


@Service
public class JpaAuditoriumService implements AuditoriumService {

	@Autowired
	private AuditoriumRepository auditoriumRepository;

	@Override
	public Auditorium findOne(Long id) {
		return auditoriumRepository.findById(id).orElse(null);
	}

	@Override
	public List<Auditorium> findAll() {
		return auditoriumRepository.findAll();
	}

	@Override
	public Auditorium update(Auditorium auditorium) {
		return auditoriumRepository.save(auditorium);
	}
	
}
