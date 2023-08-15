package com.prins.videocall.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public static final List<UserDetails> USER_LIST = new ArrayList<>();
	
	public void register(UserDetails user) {
		user.setStatus("Online");
		USER_LIST.add(user);
		
	}
	
	public UserDetails login(UserDetails user) {
		var userIndex = IntStream.range(0, USER_LIST.size())
				.filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
				.findAny()
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		var connectedUser = USER_LIST.get(userIndex);
		if(!connectedUser.getPassword().equals(user.getPassword())) {
			new RuntimeException("Password Incorrect");
		}
		connectedUser.setStatus("Online");
		return connectedUser;
	}
	
	public void logout(String email) {
		var userIndex = IntStream.range(0, USER_LIST.size())
				.filter(i -> USER_LIST.get(i).getEmail().equals(email))
				.findAny()
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		USER_LIST.get(userIndex).setStatus("Offline");
	}
	
	public List<UserDetails> findAll(){
		return USER_LIST;
	}

	
}
