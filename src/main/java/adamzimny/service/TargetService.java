package adamzimny.service;

import adamzimny.repository.TargetDAO;
import adamzimny.repository.UserDAO;
import adamzimny.model.Target;
import adamzimny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * Created by adamz on 15.08.2016.
 */
@Component
public class TargetService {

    @Autowired
    TargetDAO targetDao;

    @Autowired
    UserDAO userDao;
    private User user;

    public List<Target> getTargetsForUser(long id) {
        Optional<User> user = userDao.findById(id);
        return user.isPresent() ? targetDao.findByHunter(user.get()) : null;
    }

    public List<Target> getAll() {
        return targetDao.findAll();
    }

    public void createTarget(long hunter, long hunted, boolean p) {
       Optional<User> hunterUser =  userDao.findById(hunter);
        Optional<User> huntedUser =  userDao.findById(hunted);
        Target target = new Target();
        target.setCreated(new Date());
        target.setHunted(huntedUser.get());
        target.setHunter(hunterUser.get());
        target.setPublicTarget(p);
        targetDao.save(target);
    }
}
