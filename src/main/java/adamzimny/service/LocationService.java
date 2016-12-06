package adamzimny.service;

import adamzimny.constant.Preferences;
import adamzimny.model.Location;
import adamzimny.model.Preference;
import adamzimny.model.User;
import adamzimny.repository.LocationDAO;
import adamzimny.repository.PreferenceDAO;
import adamzimny.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by adamz on 17.08.2016.
 */
@Service
public class LocationService {

    @Autowired
    LocationDAO locationDAO;

    @Autowired
    PreferenceDAO preferenceDAO;

    @Autowired
    UserDAO userDAO;

    public List<Location> findByUserAndDateAfter(User user, Date date) {
        List<Location> list = locationDAO.findByUserAndDateAfter(user, date);
        return list;
    }

    public Location findLast(User user) {
        List<Location> list = locationDAO.findByUserOrderByDateDesc(user);
        return list == null || list.isEmpty() ? null : list.get(0);
    }


    public List<Location> findByUserAndType(User user, String type) {
        return locationDAO.findByUserAndType(user, type);
    }

    public List<Location> findByUser(User user) {
        return locationDAO.findByUser(user);
    }

    public void save(Location location) {
        locationDAO.save(location);
    }

    public Location findAverageLocation(long id) {
        Optional<User> user = userDAO.findById(id);
        if (user.isPresent()) {
            return findAverageLocation(user.get());
        }
        return null;
    }

    public Location findAverageLocation(User user) {
        Optional<Preference> daysPref = preferenceDAO.findByKey(Preferences.MAX_LOCATION_AGE_DAYS);

        List<Location> list = locationDAO.findByUserAndDateAfter(user, new Date(new Date().getTime() - 24 * 3600 * 1000 * Integer.valueOf(daysPref.isPresent()? daysPref.get().getValue() : "14")));
        if (list != null && !list.isEmpty()) {
            //TODO Compute average location
            Location location = new Location();
            return location;
        }
        return null;
    }

}
