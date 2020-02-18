package embl.recruitment.task.people.api.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import embl.recruitment.task.people.api.domain.Person;
import embl.recruitment.task.people.api.repository.PersonRepository;
import embl.recruitment.task.people.api.security.SecurityUtils;
import embl.recruitment.task.people.api.service.PersonService;
import embl.recruitment.task.people.api.service.dto.PersonDTO;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private SecurityUtils securityUtils;

	@Override
	public PersonDTO createPerson(PersonDTO personDTO) {
		Person person = modelMapper.map(personDTO, Person.class);
		person.getHobbies().stream().forEach(hoppy -> hoppy.setPerson(person));
		person.setCreatedBy(securityUtils.getLoggedInUser());
		return modelMapper.map(personRepository.save(person),PersonDTO.class);
	}

	@Override
	public PersonDTO editPerson(PersonDTO personDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDTO getPerson(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDTO> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletePerson(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
