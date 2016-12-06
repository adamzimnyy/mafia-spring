package adamzimny.controller.api;

import adamzimny.model.Code;
import adamzimny.model.Target;
import adamzimny.model.User;
import adamzimny.service.CodeService;
import adamzimny.service.TargetService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@RestController
@RequestMapping(value = "api")
public class TargetController {

    @Autowired
    TargetService targetService;

    @Autowired
    UserService userService;

    @Autowired
    CodeService codeService;

    @RequestMapping(value = "target/confirm", method = RequestMethod.PATCH)
    public ResponseEntity<Target> confirm(@RequestParam("target") long target_id, @RequestParam("code") String codeString) {
        Optional<Target> target = targetService.findById(target_id);
        if(target.isPresent()){
        Optional<Code> code = codeService.getCodeForUser(target.get().getHunted());
            if(code.isPresent() && code.get().getCode().equals(codeString)){
               return ResponseEntity.ok(targetService.confirm(target.get(), code.get()));
            }
        }

        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "target",params = "user",method = RequestMethod.GET)
    public ResponseEntity<?> getTargetsOfUser(@RequestParam("user") long user) {
        if(!userService.get(user).isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(targetService.getTargetsForUser(user));
    }


    @RequestMapping(value = "target/less",params = "user",method = RequestMethod.GET)
    public List<User> getLess(@RequestParam("count") long count) {
        return targetService.findByTargetCountLessThan(count);
    }

    @RequestMapping(value = "target", params = "id",method = RequestMethod.GET)
    public ResponseEntity<?> getTarget(@RequestParam("id") long id) {
        Optional<Target> t = targetService.findById(id);
        return t.isPresent() ? ResponseEntity.ok(t.get()) : ResponseEntity.badRequest().build();
    }

    @RequestMapping(value ="target/{hunter}/{hunted}",method = RequestMethod.POST)
    public ResponseEntity<?> createTarget(@PathVariable long hunter, @PathVariable long hunted){
        targetService.createTarget(hunter,hunted, false);
        return ResponseEntity.ok(null);
    }
}
