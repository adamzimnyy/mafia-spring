package adamzimny.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by adamz on 02.08.2016.
 */
@Entity
public class Report {
    @Id
    @GeneratedValue
    Integer id;

    @OneToOne
    User player;
    @OneToOne
    User reportedBy;
    String reason;
    String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date date;


}
