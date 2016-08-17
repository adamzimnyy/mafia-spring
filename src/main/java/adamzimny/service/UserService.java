package adamzimny.service;

import adamzimny.repository.UserDAO;
import adamzimny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by adamz on 17.08.2016.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public Optional<User> get(long id){
       return userDAO.findById(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }
}
