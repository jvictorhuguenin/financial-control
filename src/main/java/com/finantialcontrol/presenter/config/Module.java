package com.finantialcontrol.presenter.config;

import com.finantialcontrol.core.usecases.user.CreateUserUseCase;
import com.finantialcontrol.core.usecases.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {
  @Bean
  public CreateUserUseCase createUserUseCase(UserRepository userRepository){
    return new CreateUserUseCase(userRepository);
  }
}
