package com.fm.virtue.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final List<AuthenticationProvider> authenticationProviders;
    private final AuthenticationEventPublisher authenticationEventPublisher;

    @Autowired
    public WebSecurityConfig(List<AuthenticationProvider> authenticationProviders, AuthenticationEventPublisher authenticationEventPublisher) {
        this.authenticationProviders = authenticationProviders;
//        this.authenticationProvider = authenticationProvider;
        this.authenticationEventPublisher = authenticationEventPublisher;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .cors()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        authenticationProviders.forEach(auth::authenticationProvider);
        auth.authenticationEventPublisher(authenticationEventPublisher);
    }
}
