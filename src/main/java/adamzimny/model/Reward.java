package adamzimny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;


@Entity
public class Reward {

   @Id
    @GeneratedValue
    Integer id;

    @OneToOne
    User player;
    int value;
    Date added;
    String awardedFor;

    @OneToOne
    Target target;
}
