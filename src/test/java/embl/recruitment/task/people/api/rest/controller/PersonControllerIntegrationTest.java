package embl.recruitment.task.people.api.rest.controller;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;



import embl.recruitment.task.people.api.PeopleApiApplication;
import embl.recruitment.task.people.api.repository.PersonRepository;
import embl.recruitment.task.people.api.service.dto.HobbyDTO;
import embl.recruitment.task.people.api.service.dto.PersonDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = PeopleApiApplication.class)
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {
	
	private final String FIRST_NAME = "first";
	private final String LAST_NAME = "last";
	private final int AGE = 18;
	private final String FAVOURITE_COLOUR = "color";
	
	private final String FIRST_HOBBY_NAME = "hobby1";
	private final String SECOND_HOBBY_NAME = "hobby2";
	

	@Autowired
    private MockMvc mvc;
 
    @Autowired
    private PersonRepository personRepository;
    
    private PersonDTO buildPersonDTO() {
    	PersonDTO personDTO = new PersonDTO();
    	personDTO.setFirstName(FIRST_NAME);
    	personDTO.setLastName(LAST_NAME);
    	personDTO.setAge(AGE);
    	personDTO.setFavouriteColour(FAVOURITE_COLOUR);
    	personDTO.setHobbies(createHobbyDTO(FIRST_HOBBY_NAME,SECOND_HOBBY_NAME));
    	return personDTO;
    }
    
    private Set<HobbyDTO> createHobbyDTO(String... names) {
    	Set<HobbyDTO> hobbies = new HashSet<>();
    	if(names == null)
    		return hobbies;
    	for(String name:names) {
    		HobbyDTO hoppyDTO = new HobbyDTO();
    		hoppyDTO.setName(name);
    		hobbies.add(hoppyDTO);
    	}
    	return hobbies;
    }
	
}
