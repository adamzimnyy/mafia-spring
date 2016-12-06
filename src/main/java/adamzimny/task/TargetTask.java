package adamzimny.task;

import adamzimny.constant.Preferences;
import adamzimny.constant.Targets;
import adamzimny.model.Target;
import adamzimny.model.User;
import adamzimny.service.TargetService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by adamz on 05.11.2016.
 */
@Component
public class TargetTask {

    @Autowired
    TargetService targetService;

    @Autowired
    UserService userService;

    @Scheduled(cron = "0 0 0/12 * * ?")
    public void createNewTargets() {
        //TODO preferences repo
        List<User> hunters = targetService.findByTargetCountLessThan(Preferences.MAX_PRIVATE_TARGETS);
        for (User u : hunters) {
            List<User> potentialTargets = userService.findNearbyPlayers(u);
            for (int i = 0; i < Preferences.MAX_PRIVATE_TARGETS - targetService.countTargetsOf(u); i++) {
                Random r = new Random();
                int id = r.nextInt() % potentialTargets.size();
                targetService.createTarget(u.getId(), id, false);
                potentialTargets.remove(id);
            }
        }
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void makePublicTargets() {
        //TODO preferences repo
        List<Target> targetList = targetService.findExpired(false);
        for (Target t : targetList) {
            t.setPublicTarget(true);
            t.setCreated(new Date());
            t.setHunter(null);
            targetService.save(t);
        }
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void expireTargets() {
        List<Target> targetList = targetService.findExpired(true);
        for (Target t : targetList) {
            t.setStatus(Targets.FAILED);
            targetService.save(t);
        }
    }
}
