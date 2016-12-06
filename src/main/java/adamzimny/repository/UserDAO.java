package adamzimny.repository;

import adamzimny.model.Target;
import adamzimny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
@Transactional
public interface UserDAO extends JpaRepository<User,Long> {
    Optional<User> findById(long id);
    Optional<User> findByUsername(String username);
    List<User> findByStatus(String status);
    List<User> findByStatusAndAuthorities(String status,String authorities);
    List<User> findByAuthorities(String authorities);

    @Query("select u from Target t join t.hunter u group by u.id having count(t) < :count order by notargetsince asc")
    List<User> findByTargetCountLessThan(@Param("count") long count);

    Optional<User> findByEmail(String email);
}
