package com.finantialcontrol.service.authentication;

import com.finantialcontrol.dtos.UserRegistrationDto;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {
  UserDetails toUserDetails(UserRegistrationDto user){
    return User.withUsername(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRoles().toArray(new String[0]))
        .build();
  }
}
