package embl.recruitment.task.people.api.service;

import org.springframework.security.core.userdetails.UserDetails;

import embl.recruitment.task.people.api.constants.RoleEnum;
import embl.recruitment.task.people.api.domain.User;

public interface UserService {

	User createUser(String username, RoleEnum role, String password);
	
	UserDetails getUserByUserName(String username);
}
