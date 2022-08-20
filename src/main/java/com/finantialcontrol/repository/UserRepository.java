package com.finantialcontrol.repository;

import com.finantialcontrol.model.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
