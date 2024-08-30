package com.ecomerce.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.ecommerce.model.User;
import com.ecomerce.ecommerce.repositories.UserRepository;
import com.github.javafaker.Faker;

@Service
public class DatabaseSeederService {
    @Autowired
    UserRepository userRepository;
    private Faker faker = new Faker();

    public void seedDatabase() {
        for (int i = 0; i < 10; i++) {

            User user = new User().builder()
                    .email(faker.internet().emailAddress())
                    .username(faker.name().username())
                    .password(faker.internet().password())
                    .build();
            ;

            userRepository.save(user);
        }

    }

}
