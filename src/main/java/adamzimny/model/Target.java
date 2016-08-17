package adamzimny.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Target {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    @OneToOne
    User hunter;
    @OneToOne
    User hunted;
    String status;
    Date created;
    Date completed;
    boolean publicTarget = false;

    @OneToOne
    Location location;

}
