package com.fm.virtue.security.providers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

@Configuration
public class ProvidersConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
        byteBuffer.putLong(System.currentTimeMillis());
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y, new SecureRandom(byteBuffer.array()));
    }

    @Bean
    public AuthenticationProvider usernamePasswordProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }
}
