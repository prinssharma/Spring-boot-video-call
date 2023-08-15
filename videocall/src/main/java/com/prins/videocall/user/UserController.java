package com.prins.videocall.user;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
	
	private final UserService userService;
	
	
	@PostMapping
	public void register(UserDetails user) {
		userService.register(user);
		
	}
	
	@PostMapping("/login")
	public UserDetails login(UserDetails user) {
		return userService.login(user);
	}
	
	@PostMapping("/logout")
	public void logout(String email) {
		userService.logout(email);
	}
	
	@GetMapping
	public List<UserDetails> findAll(){
		return userService.findAll();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception ex){
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ex.getMessage());
	}

}
