package com.ecomerce.ecommerce;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecomerce.ecommerce.model.User;
import com.ecomerce.ecommerce.repositories.UserRepository;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository){
		return (args)->{
			// sauvegarder John Doe dans la BDD
			User johndoe = User.builder()
							.email("johndoe@gmail.com")
							.username("John Doe")
							.password("123")
							.createdAt(LocalDateTime.now())
							.updatedAt(LocalDateTime.now())
							.build();
							User john = new User(null, "John Doe","johndoe@gmail.com","123", LocalDateTime.now(), LocalDateTime.now());

							userRepository.save(john);

		};
	}

}
