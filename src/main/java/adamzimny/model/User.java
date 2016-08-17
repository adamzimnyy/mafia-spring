package adamzimny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Adam on 2016-07-15.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    String firstName;
    String lastName;
    String profilePicture;
    String profilePictureThumbnail;
    String accountStatus;
    Date registerDate;
    Date lastActive;
    int loginstreak;
    Date noTargetSince;
    int score;
    String email;
    String username;
    String password;
    float targetDistance;
    String notifications;
    String gender;
    Date dateOfBirth;
    String description;


}
