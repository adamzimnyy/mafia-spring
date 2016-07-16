package adamzimny.dao;

import adamzimny.model.Location;
import adamzimny.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adam on 2016-07-15.
 */
public interface UserDAO extends MongoRepository<User, Integer> {
}
