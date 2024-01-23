package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Seat;
import cinema.repository.SeatRepository;
import cinema.service.SeatService;

@Service
public class JpaSeatService implements SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public Seat findOne(Long id) {
		return seatRepository.findById(id).orElse(null);
	}

	@Override
	public List<Seat> findAll() {
		return seatRepository.findAll();
	}

	@Override
	public List<Seat> findByAuditoriumId(Long id) {
		return seatRepository.findByAuditoriumId(id);
	}

}
