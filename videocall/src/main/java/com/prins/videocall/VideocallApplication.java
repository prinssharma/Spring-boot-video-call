package com.prins.videocall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prins.videocall.user.UserDetails;
import com.prins.videocall.user.UserService;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
			) {
			return args -> {
				service.register(UserDetails.builder()
						.username("prins")
						.email("prins@123")
						.password("21mcmc33")
						.build());
				
				service.register(UserDetails.builder()
						.username("mayank")
						.email("mayank@123")
						.password("21mcmc24")
						.build());
				
				service.register(UserDetails.builder()
						.username("vijeta")
						.email("vijeta@123")
						.password("21mcmc20")
						.build());
				
				service.register(UserDetails.builder()
						.username("adarsh")
						.email("adarsh@123")
						.password("21mcmc21")
						.build());
								
		};
	}

}
