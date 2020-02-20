package embl.recruitment.task.people.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import embl.recruitment.task.people.api.domain.User;
import embl.recruitment.task.people.api.repository.UserRepository;

@Component
public class SecurityUtils {

	@Autowired
	private UserRepository userRepository;

	public User getLoggedInUser() {
		return userRepository.findByUsername(
				((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
	}

}
