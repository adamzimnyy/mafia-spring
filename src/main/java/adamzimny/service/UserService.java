package adamzimny.service;

import adamzimny.repository.UserDAO;
import adamzimny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by adamz on 17.08.2016.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public Optional<User> get(long id) {
        return userDAO.findById(id);
    }

    public Optional<User> get(String username) {
        return userDAO.findByUsername(username);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void register(User user) {

        user.setRegisterDate(new Date());
        user.setAccountStatus("ACTIVE");
        user.setAuthorities("USER");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        try {
            d = sdf.parse("01/01/1980");
        } catch (ParseException e) {
            d = new Date();
        }
        user.setNoTargetSince(d);

        userDAO.save(user);
    }

    public List<User> getAll() {
        List<User> users = userDAO.findAll();
        return users;
    }
}
