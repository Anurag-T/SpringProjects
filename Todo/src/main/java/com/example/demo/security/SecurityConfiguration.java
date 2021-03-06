package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	  @Bean
	    public UserDetailsService userDetailsService() throws Exception {
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(User
	          .withUsername("AnuragTyagi")
	          .password(encoder().encode("pass"))
	          .roles("USER").build());
	        manager.createUser(User
	          .withUsername("admin")
	          .password(encoder().encode("adminPass"))
	          .roles("ADMIN").build());
	        return manager;
	    }
	    
	    @Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }

}
