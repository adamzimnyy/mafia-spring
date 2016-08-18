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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getHunter() {
        return hunter;
    }

    public void setHunter(User hunter) {
        this.hunter = hunter;
    }

    public User getHunted() {
        return hunted;
    }

    public void setHunted(User hunted) {
        this.hunted = hunted;
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
