package adamzimny.controller.api;

import adamzimny.model.Location;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adam on 2016-07-15.
 */
@RestController
@RequestMapping("api")
@EnableAutoConfiguration
public class LocationController {
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Location test(){
        return new Location();
    }

}
