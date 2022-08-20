package com.finantialcontrol.service;

import com.finantialcontrol.dtos.UserGetDto;
import com.finantialcontrol.dtos.UserRegistrationDto;
import com.finantialcontrol.exceptions.UserNotFoundException;
import com.finantialcontrol.mapper.UserMapper;
import com.finantialcontrol.model.User;
import com.finantialcontrol.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserGetDto getUser(final Long id){
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()){
      return UserMapper.INSTANCE.userToUserGetDto(user.get());
    }
    else{
      throw new UserNotFoundException("Couldn't find the user with the id: " + id);
    }
  }
  public List<UserGetDto> getAllUsers(){
    List<UserGetDto> result = new ArrayList<>();
    List<User> allUsers = userRepository.findAll();

    return result;
  }

  public void register(UserRegistrationDto userDto){
    User user = User.builder().enabled(true).username(userDto.getUsername()).hash(passwordEncoder.encode(
        userDto.getPassword())).roles(new HashSet<>(Collections.singletonList("USER"))).build();
    userRepository.save(user);
  }
}
