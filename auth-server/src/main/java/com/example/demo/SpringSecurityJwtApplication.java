package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.enitiy.User;
import com.example.demo.repository.UserRepository;

@EnableEurekaClient
@SpringBootApplication
public class SpringSecurityJwtApplication {
	@Autowired
	private UserRepository userRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
	@PostConstruct
	public void intiUsers() {		
		List<User> users = Stream.of(new User(10,"kapila","kapila","kapila@kapila.com")).collect(Collectors.toList());
		userRepo.saveAll(users);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
