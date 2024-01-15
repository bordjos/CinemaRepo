package cinema.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public class PLACEHOLDERController {

//	@PreAuthorize("hasAnyAuthority('ADMIN', 'KORISNIK')")
//	@PreAuthorize("hasAuthority('ADMIN')")

//	@Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]$", message = "Datum i vreme nisu validni.")

//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<> create(@Valid @RequestBody) {
//
//
//		return new ResponseEntity<LjubimacDTO>(HttpStatus.CREATED);
//	}


//	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<> update(@PathVariable Long id, @Valid @RequestBody ) {
//
//		
//
//		return new ResponseEntity<LjubimacDTO>(HttpStatus.OK);
//	}


//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<> delete(@PathVariable Long id) {
//
//
//		if (NESTO != null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<> getOne(@PathVariable Long id) {
//
//
//		if (NESTO != null) {
//			return new ResponseEntity<>( HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//	}

//	@GetMapping
//	public ResponseEntity<List<>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
//		Page<> page;
//		
//
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
//
//		return new ResponseEntity<List<>>(headers, HttpStatus.OK);
//	}

//	@ExceptionHandler(value = DataIntegrityViolationException.class)
//	public ResponseEntity<Void> handle() {
//		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//	}
}
