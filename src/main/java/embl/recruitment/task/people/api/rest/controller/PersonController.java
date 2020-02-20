package embl.recruitment.task.people.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import embl.recruitment.task.people.api.exception.InconsistentDataException;
import embl.recruitment.task.people.api.service.PersonService;
import embl.recruitment.task.people.api.service.dto.HobbyDTO;
import embl.recruitment.task.people.api.service.dto.PersonDTO;
import static java.util.stream.Collectors.toList;
@RestController
@RequestMapping("/api")
public class PersonController {

	private final static String RESOURCE_NAME = "Person";
	@Autowired
	private PersonService personService;
	
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping("/person")
	public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO) throws InconsistentDataException{
		if(personDTO.getId()!=null)
			throw new InconsistentDataException(RESOURCE_NAME, "id has value");
		
		List<HobbyDTO> notValidHobbies = personDTO.getHobbies().stream().filter(hobby -> hobby.getId() != null).collect(toList());
		if(!notValidHobbies.isEmpty())	
			throw new InconsistentDataException(RESOURCE_NAME, "hoppies ids some or all of them have values");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personDTO));
		
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@PutMapping("/person")
	public ResponseEntity<PersonDTO> editPerson(@Valid @RequestBody PersonDTO personDTO){
		if(personDTO.getId()==null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.editPerson(personDTO));
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<PersonDTO>> getPersons(){
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(id));
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> DeletePerson(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(id));
	}
}
