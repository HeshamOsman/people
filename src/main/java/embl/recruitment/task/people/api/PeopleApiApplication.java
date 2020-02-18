package embl.recruitment.task.people.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import embl.recruitment.task.people.api.constants.RoleEnum;
import embl.recruitment.task.people.api.service.UserService;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"embl.recruitment.task.people.api.repository"})
public class PeopleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApiApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	
	@Value("${people.users.admin.username}")
	private String adminUsername;
	
	@Value("${people.users.admin.password}")
	private String adminPassword;
	
	@Value("${people.users.nonAdmin.username}")
	private String nonAdminUsername;
	
	@Value("${people.users.nonAdmin.password}")
	private String nonAdminPassword;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		userService.createUser(adminUsername, RoleEnum.ADMIN, adminPassword);
		userService.createUser(nonAdminUsername, RoleEnum.ADMIN, nonAdminPassword);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
