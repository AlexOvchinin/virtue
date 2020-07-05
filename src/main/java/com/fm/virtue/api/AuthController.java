package com.fm.virtue.api;

import com.fm.virtue.security.AuthenticationFacade;
import com.fm.virtue.security.userdetails.UserPrincipal;
import com.fm.virtue.users.User;
import com.fm.virtue.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, AuthenticationFacade authenticationFacade, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationFacade = authenticationFacade;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/auth")
    ResponseEntity<?> getAuth() {
        Authentication authentication = authenticationFacade.getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        return ResponseEntity.of(Optional.of(new UserResponse(userPrincipal.getUser().getId())));
    }

    @PostMapping("/register")
    ResponseEntity<?> postRegister(@RequestBody UserResource userResource) {
        LOGGER.info("Registering new user");
        Objects.requireNonNull(userResource.getUsername());
        Objects.requireNonNull(userResource.getPassword());

        User user = userRepository.save(new User(userResource.getUsername(), passwordEncoder.encode(userResource.getPassword())));
        return ResponseEntity.of(Optional.of(new UserResponse(user.getId())));

    }
}
