package adamzimny.controller.api;

import adamzimny.model.Target;
import adamzimny.model.User;
import adamzimny.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;

/**
 * Created by Adam on 2016-07-15.
 */
@RestController
@RequestMapping(value = "api")
public class TargetController {

    @Autowired
    TargetService service;

    @RequestMapping(value = "target/get", method = RequestMethod.GET)
    public List<Target> getTargetsOfUser(@RequestParam long id) {
        return service.getTargetsForUser(id);
    }

    @RequestMapping(value = "target/getAll", method = RequestMethod.GET)
    public List<Target> getAllTargets() {
        return service.getAll();
    }
}
