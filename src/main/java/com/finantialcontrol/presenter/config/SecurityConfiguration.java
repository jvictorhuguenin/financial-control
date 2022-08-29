package com.finantialcontrol.presenter.config;

import com.finantialcontrol.service.authentication.DatabaseUserDetailsPasswordService;
import com.finantialcontrol.service.authentication.DatabaseUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
  private final DatabaseUserDetailsService databaseUserDetailsService;
  private final DatabaseUserDetailsPasswordService databaseUserDetailsPasswordService;

  public SecurityConfiguration(DatabaseUserDetailsService databaseUserDetailsService,
                               DatabaseUserDetailsPasswordService databaseUserDetailsPasswordService) {
    this.databaseUserDetailsService = databaseUserDetailsService;
    this.databaseUserDetailsPasswordService = databaseUserDetailsPasswordService;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/registry")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();

    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(10);
  }

  @Bean
  public AuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsPasswordService(this.databaseUserDetailsPasswordService);
    provider.setUserDetailsService(this.databaseUserDetailsService);
    return provider;
  }

}
