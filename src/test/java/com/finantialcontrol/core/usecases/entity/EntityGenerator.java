package com.finantialcontrol.core.usecases.entity;

import com.finantialcontrol.core.domain.Identity;
import com.finantialcontrol.core.domain.User;
import com.finantialcontrol.core.domain.UserStatus;
import com.github.javafaker.Faker;

public final class EntityGenerator {
  private static final Faker faker = new Faker();

  public static User createRandomUser(){
    return new User(
        new Identity(faker.number().randomNumber()),
        faker.name().firstName(),
        faker.name().lastName(),
        faker.name().username(),
        faker.internet().emailAddress(),
        faker.internet().password(),
        UserStatus.ENABLED
    );
  }
}
