package adamzimny.repository;

import adamzimny.model.Target;
import adamzimny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
@Transactional
public interface TargetDAO extends JpaRepository<Target,Integer> {
    List<Target> findByHunter(User hunter);
    List<Target> findByHunterAndPublicTargetAndStatus(User hunter, boolean publicTarget, String status);
    List<Target> findByHunted(User hunted);
    List<Target>findByHunterAndHunted(User hunter, User hunted);
    Optional<Target> findById(Integer id);
    List<Target> findByPublicTargetAndStatusAndCreatedBefore(boolean b, String active, Date from);
    List<Target> findByPublicTarget(boolean b);
}
