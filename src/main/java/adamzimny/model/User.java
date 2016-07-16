package adamzimny.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Adam on 2016-07-15.
 */
public class User {
    @Id
    private int id;
    String firstName;
    String lastName;
    String profilePicture;
    Location homeLocation;
    String status;
}
