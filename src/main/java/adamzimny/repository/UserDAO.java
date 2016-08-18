package adamzimny.repository;

import adamzimny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    Optional<User> findById(long id);
    Optional<User> findByUsername(String username);
}
