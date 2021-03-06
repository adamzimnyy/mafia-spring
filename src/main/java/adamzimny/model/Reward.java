package adamzimny.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss zzz")
    Date added;
    String awardedFor;

    @OneToOne
    Target target;
}
