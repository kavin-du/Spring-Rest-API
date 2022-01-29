package com.wbot;

import com.wbot.models.AppUser;
import com.wbot.models.Role;
import com.wbot.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtAmigosApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAmigosApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(0, "ROLE_USER"));
			userService.saveRole(new Role(0, "ROLE_MANAGER"));
			userService.saveRole(new Role(0, "ROLE_ADMIN"));
			userService.saveRole(new Role(0, "ROLE_SUPER_ADMIN"));

			
			userService.saveUser(new AppUser(0, "John Rambo", "john", "1234", null));
			userService.saveUser(new AppUser(0, "Will Smith", "will", "1234", null));
			userService.saveUser(new AppUser(0, "Json Stathem", "json", "1234", null));
			userService.saveUser(new AppUser(0, "Arnold Subasinghe", "arnold", "1234", null));


			userService.addRoleToUser("john", "ROLE_USER");	
			userService.addRoleToUser("john", "ROLE_MANAGER");	
			userService.addRoleToUser("will", "ROLE_MANAGER");	
			userService.addRoleToUser("json", "ROLE_ADMIN");	
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");	
			userService.addRoleToUser("arnold", "ROLE_ADMIN");	
			userService.addRoleToUser("arnold", "ROLE_USER");	
		};
	}

}
