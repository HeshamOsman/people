package embl.recruitment.task.people.api.service;


import java.util.List;

import embl.recruitment.task.people.api.service.dto.PersonDTO;

public interface PersonService {
	
	PersonDTO createPerson(PersonDTO personDTO);
	
	PersonDTO editPerson(PersonDTO personDTO);
    
	PersonDTO getPerson(Long id);
	
	List<PersonDTO> getAllPersons();
	
	Boolean deletePerson(Long id);
	
}
