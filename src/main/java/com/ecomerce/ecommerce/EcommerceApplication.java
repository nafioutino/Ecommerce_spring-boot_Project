package com.ecomerce.ecommerce;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecomerce.ecommerce.services.DatabaseSeederService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean // permet de créer un objet et de le rendre disponible dans le contexte Spring
	public CommandLineRunner demo(DatabaseSeederService databaseSeederService) {
		return (args) -> {
		databaseSeederService.seedDatabase();
		};
	}

}
