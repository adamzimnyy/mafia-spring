package adamzimny.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Adam on 2016-07-15.
 */
public class Location {
    @Id
    int id;
    long latitude;
    long longitute;
    String city;
    String country;
    String type;
    Date created;
}
