package com.prins.videocall.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String status; 

}
