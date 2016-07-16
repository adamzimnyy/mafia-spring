package adamzimny.dao;

import adamzimny.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adam on 2016-07-15.
 */
public interface LocationDAO extends MongoRepository<Location, Integer> {
}
