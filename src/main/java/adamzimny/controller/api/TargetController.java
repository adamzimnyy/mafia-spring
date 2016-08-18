package adamzimny.controller.api;

import adamzimny.model.Target;
import adamzimny.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Adam on 2016-07-15.
 */
@RestController
@RequestMapping(value = "api")
@PreAuthorize("@securityService.hasProtectedAccess()")
public class TargetController {

    @Autowired
    TargetService targetService;

    @RequestMapping(value = "target/{id}", method = RequestMethod.GET)
    public List<Target> getTargetsOfUser(@PathVariable long id) {
        return targetService.getTargetsForUser(id);
    }

    @RequestMapping(value = "target", method = RequestMethod.GET)
    public List<Target> getAllTargets() {
        return targetService.getAll();
    }

    @RequestMapping(value ="target/{hunter}/{hunted}",method = RequestMethod.POST)
    public ResponseEntity<?> createTarget(@PathVariable long hunter, @PathVariable long hunted){
        targetService.createTarget(hunter,hunted, false);
        return ResponseEntity.ok(null);
    }
}
