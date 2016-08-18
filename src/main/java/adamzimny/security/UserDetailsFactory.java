package adamzimny.security;

import adamzimny.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class UserDetailsFactory {

  public static MyUserDetails create(User user) {
    return new MyUserDetails(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      user.getEmail(),
      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
    );
  }

}
