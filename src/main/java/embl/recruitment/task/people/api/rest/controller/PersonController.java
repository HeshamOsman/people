package embl.recruitment.task.people.api.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import embl.recruitment.task.people.api.service.PersonService;
import embl.recruitment.task.people.api.service.dto.PersonDTO;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/person")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody PersonDTO personDTO){
		final PersonDTO responseDTO = personService.createPerson(personDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}
}
