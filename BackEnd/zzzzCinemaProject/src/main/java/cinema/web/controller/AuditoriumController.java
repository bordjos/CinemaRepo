package cinema.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Auditorium;
import cinema.model.Seat;
import cinema.service.AuditoriumService;
import cinema.service.SeatService;
import cinema.support.AuditoriumDTOToAuditorium;
import cinema.support.AuditoriumToAuditoriumDTO;
import cinema.support.SeatToSeatDTO;
import cinema.web.dto.AuditoriumDTO;
import cinema.web.dto.SeatDTO;

@RestController
@RequestMapping(value = "/api/auditoriums", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuditoriumController {

	@Autowired
	private AuditoriumService auditoriumService;
	
	@Autowired
	private SeatService seatService;

	@Autowired
	private AuditoriumToAuditoriumDTO toAuditoriumDTO;

	@Autowired
	private AuditoriumDTOToAuditorium toAuditorium;
	
	@Autowired
	private SeatToSeatDTO toSeatDTO;

	// this was added just in case I implement the feature to change the auditoriums
	// name
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuditoriumDTO> update(@PathVariable Long id,
			@Valid @RequestBody AuditoriumDTO auditoriumDTO) {

		if (!id.equals(auditoriumDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Auditorium auditorium = toAuditorium.convert(auditoriumDTO);

		return new ResponseEntity<AuditoriumDTO>(toAuditoriumDTO.convert(auditoriumService.update(auditorium)),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AuditoriumDTO> getOne(@PathVariable Long id) {

		Auditorium auditorium = auditoriumService.findOne(id);

		if (auditorium != null) {
			return new ResponseEntity<>(toAuditoriumDTO.convert(auditorium), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<AuditoriumDTO>> getAll() {

		List<Auditorium> auditoriums = auditoriumService.findAll();

		return new ResponseEntity<>(toAuditoriumDTO.convert(auditoriums), HttpStatus.OK);

	}
	
	@GetMapping(value = "/{id}/seats")
	public ResponseEntity<List<SeatDTO>> getByAuditoriumId(@PathVariable Long id) {
		List<Seat> seats = seatService.findByAuditoriumId(id);
		
		return new ResponseEntity<>(toSeatDTO.convert(seats), HttpStatus.OK);
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
