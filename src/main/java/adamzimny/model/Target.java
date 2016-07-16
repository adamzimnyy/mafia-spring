package adamzimny.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Adam on 2016-07-15.
 */
public class Target {

    @Id
    int id;
    User killer;
    User victim;
    String status;
    Date created;
    Date completed;
    boolean global = false;
}
