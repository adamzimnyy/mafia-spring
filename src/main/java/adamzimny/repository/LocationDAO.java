package adamzimny.repository;

import adamzimny.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
public interface LocationDAO extends JpaRepository<Location,Integer> {
}
