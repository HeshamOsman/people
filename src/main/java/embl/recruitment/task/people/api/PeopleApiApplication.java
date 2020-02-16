package embl.recruitment.task.people.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import embl.recruitment.task.people.api.constants.RoleEnum;
import embl.recruitment.task.people.api.repository.UserRepository;
import embl.recruitment.task.people.api.service.UserService;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"embl.recruitment.task.people.api.repository"})
public class PeopleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApiApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		userService.createUser("Hesham", RoleEnum.ADMIN, "123456");
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}

}
