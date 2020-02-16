package embl.recruitment.task.people.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import embl.recruitment.task.people.api.constants.RoleEnum;
import embl.recruitment.task.people.api.domain.User;
import embl.recruitment.task.people.api.repository.RoleRepository;
import embl.recruitment.task.people.api.repository.UserRepository;
import embl.recruitment.task.people.api.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(String username, RoleEnum role, String password) {
		User u = new User();
		u.setPassword(passwordEncoder.encode(password));
		u.setUsername(username);
		u.setRole(roleRepository.findBySlug(role.toString().toLowerCase()));
		u = userRepository.save(u);
		
		System.out.println(u);
		
		return u;
		
	}

	@Override
	public UserDetails getUserByUserName(String username) {
		User u = userRepository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(u.getUsername(),u.getPassword(),Arrays.asList(u.getRole()));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(u.getUsername(),u.getPassword(),Arrays.asList(u.getRole()));
	}
	
	
	

	
	
}
