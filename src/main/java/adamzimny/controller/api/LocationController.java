package adamzimny.controller.api;

import adamzimny.constant.Locations;
import adamzimny.model.Location;
import adamzimny.model.User;
import adamzimny.service.LocationService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

    @RequestMapping(value = "last", method = RequestMethod.GET)
    public ResponseEntity<?> findLastUserLocation(@RequestParam("user") long id) {
        Optional<User> user = userService.get(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(locationService.findLast(user.get()));
        }

        return ResponseEntity.badRequest().body("User not found!");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Location location) {
        try {
            locationService.save(location);
            User u = location.getUser();
            u.setLatitude(location.getLatitude());
            u.setLongitude(location.getLongitude());
            if (location.getType().equals(Locations.LOGIN)) {
                LocalDate yesterday = LocalDate.now().minusDays(1);
                LocalDate now = LocalDate.now();
                if (u.getLastActive() != null) {
                    LocalDate last = u.getLastActive().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    if (last.equals(yesterday)) {
                        u.setLoginstreak(u.getLoginstreak() + 1);
                    } else if (last.isBefore(yesterday)) {
                        u.setLoginstreak(1);
                    }
                } else {
                    u.setLoginstreak(1);

                }
                u.setLastActive(new Date());

            }
            userService.save(u);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return ResponseEntity.badRequest().body(sw.toString());
        }
        return ResponseEntity.ok("Location save success.");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> findByUserAndDateAfter(
            @RequestParam("user") long id,
            @RequestParam(value = "date", required = false) String dateString)
            throws ParseException {

        Optional<User> user = userService.get(id);
        if (user.isPresent()) {
            if (dateString != null) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
                Date date = df.parse(dateString);

                return ResponseEntity.ok(locationService.findByUserAndDateAfter(user.get(), date));
            } else {
                return ResponseEntity.ok(locationService.findByUser(user.get()));
            }
        }
        return ResponseEntity.badRequest().body("User not found!");
    }
}
