package adamzimny.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Adam on 2016-07-15.
 */
public class Preference {
    @Id
    String key;
    String value;
}
