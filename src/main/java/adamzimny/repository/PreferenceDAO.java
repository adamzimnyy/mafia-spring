package adamzimny.repository;

import adamzimny.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@Repository
@Transactional
public interface PreferenceDAO extends JpaRepository<Preference, String> {

    Optional<Preference> findByKey(String key);

}
