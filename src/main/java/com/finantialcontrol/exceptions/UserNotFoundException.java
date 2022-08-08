package com.finantialcontrol.exceptions;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(String exception) {
    super(exception);
  }
}
