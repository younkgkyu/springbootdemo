package kr.yklee.springbootdemo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.yklee.springbootdemo.domain.User;
import kr.yklee.springbootdemo.domain.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	@PostConstruct
	public void init() {
		User user = userRepository.findByUsername("yklee");
		if (user == null) {
			user = new User();
			user.setUsername("yklee");
			user.setPassword("pass");
			User newUser = this.save(user);
			System.out.println(newUser);			
		}
		System.out.println("yklee pass encode : " + passwordEncoder.encode("yklee-password"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities());
	}

	private Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
}
