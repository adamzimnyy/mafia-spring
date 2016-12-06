package adamzimny.mapper;

import adamzimny.model.User;
import adamzimny.model.json.request.UserTemplate;

import java.util.Date;

/**
 * Created by adamz on 19.08.2016.
 */
public class UserMapper {

    public static User map(UserTemplate template){
        User user = new User();
        user.setFirstName(template.getFirstName());
        user.setLastName(template.getLastName());
        user.setDateOfBirth(template.getDateOfBirth());
        user.setDescription(template.getDescription());
        user.setNotifications(template.getNotifications());
        user.setEmail(template.getEmail());
        user.setUsername(template.getUsername());
        user.setPassword(template.getPassword());
        user.setGender(template.getGender());
        user.setTargetDistance(template.getTargetDistance());
        user.setProfilePicture(template.getProfilePicture());
        return user;
    }

    public static User map(User user, UserTemplate template) {
        user.setFirstName(template.getFirstName());
        user.setLastName(template.getLastName());
        user.setDateOfBirth(template.getDateOfBirth());
        user.setDescription(template.getDescription());
        user.setNotifications(template.getNotifications());
        user.setEmail(template.getEmail());
        user.setUsername(template.getUsername());
        user.setPassword(template.getPassword());
        user.setGender(template.getGender());
        user.setTargetDistance(template.getTargetDistance());
        user.setProfilePicture(template.getProfilePicture());
        return user;
    }
}
