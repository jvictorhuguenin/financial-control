package com.finantialcontrol.infrastructure.data.db.jpa.repositories;

import com.finantialcontrol.infrastructure.data.db.jpa.entities.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
