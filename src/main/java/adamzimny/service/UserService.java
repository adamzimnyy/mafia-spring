package adamzimny.service;

import adamzimny.constant.Users;
import adamzimny.model.User;
import adamzimny.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by adamz on 17.08.2016.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public Optional<User> get(long id) {
        return userDAO.findById(id);
    }

    public Optional<User> get(String username) {
        return userDAO.findByUsername(username);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public User register(User user) {
        user.setRegisterDate(new Date());
        user.setStatus("ACTIVE");
        user.setAuthorities("ROLE_USER");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        try {
            d = sdf.parse("01/01/1980");
        } catch (ParseException e) {
            d = new Date();
        }
        user.setNoTargetSince(d);

        userDAO.save(user);
        return user;
    }

    public List<User> getAll() {
        List<User> users = userDAO.findAll();
        return users;
    }

    public void delete(long id) {
        userDAO.delete(id);
    }

    public List<User> getByStatus(String status) {
        return userDAO.findByStatus(status);
    }

    public List<User> getByRole(String role) {
        return userDAO.findByAuthorities(role);
    }

    public List<User> getByStatusAndRole(String status, String role) {
        return userDAO.findByStatusAndAuthorities(status, role);

    }

    public Optional<User> getByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public List<User> findNearbyPlayers(User u) {
        List<User> results = new ArrayList<>();
        List<User> activeUsers = userDAO.findByStatus(Users.ACTIVE);
        for(User a : activeUsers){
            if(a!= u && getDistance(a,u)){
                results.add(a);
            }
        }
        return results;
    }

    private boolean getDistance(User a, User u) {
        return distance(a.getLatitude(),u.getLatitude(),a.getLongitude(),u.getLongitude(),0,0) <= u.getTargetDistance();
    }

    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
}
