package kr.yklee.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.yklee.springbootdemo.domain.User;
import kr.yklee.springbootdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> listUser() {
		return userService.findAll();
	}
	
	@PostMapping("/user")
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "success";
	}
	
}
