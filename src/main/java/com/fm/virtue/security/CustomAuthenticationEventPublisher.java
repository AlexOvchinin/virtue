package com.fm.virtue.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEventPublisher implements AuthenticationEventPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationEventPublisher.class);

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        LOGGER.warn("Succesful authentification");
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        LOGGER.warn("Failed authentification");
    }
}
