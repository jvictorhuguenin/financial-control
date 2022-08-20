package com.finantialcontrol.service.authentication;

import com.finantialcontrol.mapper.UserMapper;
import com.finantialcontrol.model.User;
import com.finantialcontrol.repository.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DatabaseUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  private final UserDetailsMapper userDetailsMapper;

  @Autowired
  public DatabaseUserDetailsService(
      UserRepository userRepository, UserDetailsMapper userDetailsMapper) {
    this.userRepository = userRepository;
    this.userDetailsMapper = userDetailsMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    return userDetailsMapper.toUserDetails(UserMapper.INSTANCE.userToUserPostDto(user));
  }
}
