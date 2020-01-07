package kr.yklee.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import kr.yklee.springbootdemo.domain.User;

public interface UserService {

	Optional<User> findById(Long id);
	List<User> findAll();
	User findByUserName(String username);
	User save(User user);
	void delete(Long id);
	
}
