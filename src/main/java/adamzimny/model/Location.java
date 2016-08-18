package adamzimny.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Location {
    @Id
    @GeneratedValue
    Integer id;
    long latitude;
    long longitute;
    String type;
    Date date;

    @OneToOne
    User user;


    public int getId() {
        return id;
    }
}
