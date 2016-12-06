package adamzimny.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Target {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    @OneToOne
    User hunted;
    @OneToOne
    User hunter;
    String status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z" )
    Date created;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date completed;
    boolean publicTarget = false;

    @OneToOne
    Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getHunted() {
        return hunted;
    }

    public void setHunted(User hunted) {
        this.hunted = hunted;
    }

    public User getHunter() {
        return hunter;
    }

    public void setHunter(User hunter) {
        this.hunter = hunter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public boolean isPublicTarget() {
        return publicTarget;
    }

    public void setPublicTarget(boolean publicTarget) {
        this.publicTarget = publicTarget;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
