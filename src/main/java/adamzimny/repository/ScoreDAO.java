package adamzimny.repository;

import adamzimny.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by adamz on 04.11.2016.
 */

@Repository
@Transactional
public interface ScoreDAO extends JpaRepository<Reward,Integer>{
}
