package adamzimny.dao;

import adamzimny.model.Location;
import adamzimny.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adam on 2016-07-15.
 */
public interface PreferenceDAO extends MongoRepository<Preference, String> {

    public Preference findByKey(String key);

}
