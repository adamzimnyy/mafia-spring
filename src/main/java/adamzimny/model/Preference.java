package adamzimny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Adam on 2016-07-15.
 */
@Entity
public class Preference {
    @Id
    String key;
    String value;

}
