package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// @EnableMethodSecurity
public class SegurityConfig {
  
  @Bean
  public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    // UserDetails admin = User.withUsername("Angel")
    //   .password(encoder.encode("12345"))
    //   .roles("ADMIN")
    //   .build();
    // UserDetails user = User.withUsername("User")
    //   .password(encoder.encode("12345"))
    //   .roles("USER")
    //   .build();
    return new UserInfoUserDetailsService();
  }

  @Bean 
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
      .authorizeHttpRequests()
      .requestMatchers("/api/v1/users/**").permitAll()
      .and()
      .authorizeHttpRequests().requestMatchers("/api/v1/users/**")
      .authenticated()
      .and().formLogin()
      .and().build();  
      }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
