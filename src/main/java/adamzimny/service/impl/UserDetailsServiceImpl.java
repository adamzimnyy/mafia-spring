package adamzimny.service.impl;

import adamzimny.model.User;
import adamzimny.repository.UserDAO;
import adamzimny.security.UserDetailsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDAO userDAO;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = this.userDAO.findByUsername(username);

    if (user == null || !user.isPresent()) {
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    } else {
      return UserDetailsFactory.create(user.get());
    }
  }

}
