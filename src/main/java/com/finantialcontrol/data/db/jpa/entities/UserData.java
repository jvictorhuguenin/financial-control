package com.finantialcontrol.data.db.jpa.entities;

import com.finantialcontrol.core.domain.Identity;
import com.finantialcontrol.core.domain.User;
import com.finantialcontrol.core.domain.UserStatus;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class UserData{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String password;
  private Boolean enabled = true;

  public static UserData from(User user) {
    return new UserData(
        user.getId().getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getUsername(),
        user.getEmail(),
        user.getPassword(),
        true
    );
  }

  public User fromThis(){
    return new User(
        new Identity(id),
        firstName,
        lastName,
        username,
        email,
        password,
        UserStatus.ENABLED
    );
  }
}