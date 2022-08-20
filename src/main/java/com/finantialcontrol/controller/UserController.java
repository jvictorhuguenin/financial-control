package com.finantialcontrol.controller;

import com.finantialcontrol.dtos.UserGetDto;
import com.finantialcontrol.dtos.UserRegistrationDto;
import com.finantialcontrol.service.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserGetDto> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public UserGetDto getUser(@PathVariable final Long id){
    return userService.getUser(id);
  }

  @PostMapping("/registry")
  @ResponseStatus(code = HttpStatus.CREATED)
  public void postUser(@RequestBody final UserRegistrationDto user){
    userService.register(user);
  }

}
