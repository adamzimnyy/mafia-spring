package adamzimny.repository;

import adamzimny.model.Target;
import adamzimny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
@Transactional
public interface TargetDAO extends JpaRepository<Target,Integer> {
    List<Target> findByHunter(User hunter);
}
