package cinema.service;

import java.util.List;

import cinema.model.Seat;

public interface SeatService {

	Seat findOne(Long id);

	List<Seat> findAll();

	List<Seat> findByAuditoriumId(Long id);
}
