package embl.recruitment.task.people.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import embl.recruitment.task.people.api.domain.Person;
import embl.recruitment.task.people.api.repository.PersonRepository;
import embl.recruitment.task.people.api.security.SecurityUtils;
import embl.recruitment.task.people.api.service.PersonService;
import embl.recruitment.task.people.api.service.dto.PersonDTO;
import static java.util.stream.Collectors.toList;

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
		return savePerson(personDTO);
	}

	@Override
	public PersonDTO editPerson(PersonDTO personDTO) {
		return savePerson(personDTO);
	}

	@Override
	public PersonDTO getPerson(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.isEmpty()?null: modelMapper.map(person.get(),PersonDTO.class);
	}

	@Override
	public List<PersonDTO> getAllPersons() {
		return personRepository.findAll().stream().map(person -> modelMapper.map(person, PersonDTO.class)).collect(toList());
	}

	@Override
	public Boolean deletePerson(Long id) {
		personRepository.deleteById(id);
		return true;
	}

	private PersonDTO savePerson(PersonDTO personDTO) {
		Person person = modelMapper.map(personDTO, Person.class);
		person.getHobbies().stream().forEach(hoppy -> hoppy.setPerson(person));
		person.setCreatedBy(securityUtils.getLoggedInUser());
		return modelMapper.map(personRepository.save(person),PersonDTO.class);
	}
	
	
	
}
