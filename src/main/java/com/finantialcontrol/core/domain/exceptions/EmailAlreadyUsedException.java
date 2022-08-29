package com.finantialcontrol.core.domain.exceptions;

public class EmailAlreadyUsedException extends RuntimeException{
  public EmailAlreadyUsedException(String message) {
    super(message);
  }
}
