package com.fm.virtue.api;

import com.fm.virtue.users.User;
import com.fm.virtue.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/auth")
    ResponseEntity<?> auth() {
        userRepository.save(new User(""));
        return ResponseEntity.accepted().body("");
    }
}
