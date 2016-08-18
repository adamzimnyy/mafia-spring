package adamzimny.controller.api;

import adamzimny.model.Location;
import adamzimny.model.User;
import adamzimny.service.LocationService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by adamz on 17.08.2016.
 */

@RestController
@RequestMapping(value = "api/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public List<Location> findByUser(@PathVariable long id) {
        Optional<User> user = userService.get(id);
        if (user.isPresent()) {
            return locationService.findByUser(user.get());
        }
        return null;
    }

    @RequestMapping(value = "user/{id}/{date}")
    public List<Location> findByUserAndDateAfter(@PathVariable long id, @PathVariable long date) {
        Optional<User> user = userService.get(id);
        if (user.isPresent()) {
            return locationService.findByUserAndDateAfter(user.get(), date);
        }
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Location location){
        locationService.save(location);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
