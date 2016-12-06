package adamzimny.repository;

import adamzimny.model.Location;
import adamzimny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
@Transactional
public interface LocationDAO extends JpaRepository<Location,Integer> {

    List<Location> findByUserAndDateAfter(User user, Date date);
    List<Location> findByUserAndType(User user, String type);
    List<Location> findByUser(User user);
    List<Location> findByUserOrderByDateDesc(User user);
}
