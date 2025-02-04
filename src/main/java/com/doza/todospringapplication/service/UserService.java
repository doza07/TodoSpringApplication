package com.doza.todospringapplication.service;

import com.doza.todospringapplication.entity.User;
import com.doza.todospringapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) {
        if((userRepository.findByEmail(user.getEmail()).isPresent())) {
            throw new RuntimeException("Email already exists");
        }
        //TODO установка возраста юзера от даты рождения
        //user.setAge(Preiod.between(user.getBirthday(), LocalDate.now().getYear()));
        return userRepository.save(user);
    }

    public void update(Long id, String username, String email, String password, LocalDate birthday) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User existingUser = user.get();

        if((email != null && userRepository.findByEmail(email).isPresent())) {
            throw new RuntimeException("Email already exists");
        }

        existingUser.setEmail(email);

        if(existingUser.getUsername() != null && !(existingUser.getUsername().equals(username))) {
            existingUser.setUsername(username);
        }

        if(existingUser.getPassword() != null && !(existingUser.getPassword().equals(password))) {
            existingUser.setPassword(password);
        }

        if(existingUser.getBirthday() != null && !(existingUser.getBirthday().equals(birthday))) {
            existingUser.setBirthday(birthday);
        }
    }

    public void deleteById(Long id) {
        if(userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

}
