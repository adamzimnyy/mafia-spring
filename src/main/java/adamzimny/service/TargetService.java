package adamzimny.service;

import adamzimny.constant.Preferences;
import adamzimny.constant.Targets;
import adamzimny.model.Code;
import adamzimny.model.Target;
import adamzimny.model.User;
import adamzimny.repository.TargetDAO;
import adamzimny.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TargetService {

    @Autowired
    TargetDAO targetDao;

    @Autowired
    UserDAO userDao;
    private User user;

    public List<Target> getTargetsForUser(long id) {
        Optional<User> user = userDao.findById(id);
        List<Target> priv = targetDao.findByHunter(user.get());
        priv.addAll(targetDao.findByPublicTarget(true));
        return user.isPresent() ? priv : null;
    }

    public List<Target> getAll() {
        return targetDao.findAll();
    }

    public void createTarget(long hunter, long hunted, boolean p) {
        Optional<User> hunterUser = userDao.findById(hunter);
        Optional<User> huntedUser = userDao.findById(hunted);
        Target target = new Target();
        target.setCreated(new Date());
        target.setHunted(huntedUser.get());
        target.setHunter(hunterUser.get());
        target.setPublicTarget(p);
        target.setStatus(Targets.ACTIVE);
        targetDao.save(target);
    }

    public Optional<Target> findById(long target_id) {
        return targetDao.findById((int) target_id);
    }


    public Target confirm(Target target, Code code) {
        target.setCompleted(new Date());
        target.setStatus("COMPLETED");
        target.setLocation(code.getLocation());
        targetDao.save(target);
        return target;
    }

    public List<User> findByTargetCountLessThan(long count){
        return userDao.findByTargetCountLessThan(count);
    }

    public List<Target> findExpired(boolean publi) {
        LocalDateTime daysAgo = LocalDateTime.now().minusDays(Preferences.PRIVATE_TARGET_DAYS);
        return targetDao.findByPublicTargetAndStatusAndCreatedBefore(publi,Targets.ACTIVE,Date.from(daysAgo.atZone(ZoneId.systemDefault()).toInstant()));
    }

    public void save(Target t) {
        targetDao.save(t);
    }

    public long countTargetsOf(User u) {
        return targetDao.findByHunterAndPublicTargetAndStatus(u,false,"ACTIVE").size();
    }
}
