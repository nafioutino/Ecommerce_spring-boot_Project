package com.ecomerce.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecomerce.ecommerce.model.User;
import com.ecomerce.ecommerce.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User non trouvé"));
        return user;
    }

    public User createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }

    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository
                .findById(id) // cherche l'utilisateur correspondant à l'id fourni
                .orElseThrow(() -> new RuntimeException("User avec l'id " + id + " non trouvé")); // renvoie une
                                                                                                  // exception si
                                                                                                  // l'utilisateur n'est
                                                                                                  // pas trouvé
        userToUpdate.setUsername(user.getUsername()); // met à jour le nom d'utilisateur
        userToUpdate.setEmail(user.getEmail()); // met à jour l'adresse e-mail
        userToUpdate.setPassword(user.getPassword()); // met à jour le mot de passe
        return userToUpdate;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id); // supprime l'utilisateur correspondant à l'id fourni
    }
}
