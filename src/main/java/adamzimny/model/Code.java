package adamzimny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;


@Entity
public class Code {
    @Id
    @GeneratedValue
    Integer id;

    @OneToOne
    User source;

    @OneToOne
    User destination;
    String code;
    Date created;
    @OneToOne
    Location location;

}
