package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.test.entities.User;
import com.test.repositories.UserRepository;

@SpringBootApplication
public class SpringBootCrudBackEndApplication implements CommandLineRunner {

	private @Autowired UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudBackEndApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		userRepository.save(new User("Anil", "Jinnarapu"));
//		userRepository.save(new User("Sunil", "Jinnarapu"));
//		userRepository.save(new User("Suhani", "Jinnarapu"));
//		userRepository.save(new User("Likith", "Jinnarapu"));
		
//		userRepository.findBySearchTermNative("a", new PageRequest(0, 5));
		userRepository.findBySearch("a",new PageRequest(0, 5));
	}
}
