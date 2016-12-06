package adamzimny.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Adam on 2016-07-15.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    String firstName;
    String lastName;

    @Column(unique = true)
    String profilePicture;
    String status;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date registerDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date lastActive;
    int loginstreak;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date noTargetSince;
    int score;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String username;
    String password;
    float targetDistance;
    String notifications;
    String gender;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date dateOfBirth;
    String description;
    String authorities;

    double latitude;
    double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", status='" + status + '\'' +
                ", registerDate=" + registerDate +
                ", lastActive=" + lastActive +
                ", loginstreak=" + loginstreak +
                ", noTargetSince=" + noTargetSince +
                ", score=" + score +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", targetDistance=" + targetDistance +
                ", notifications='" + notifications + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", description='" + description + '\'' +
                ", authorities='" + authorities + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public int getLoginstreak() {
        return loginstreak;
    }

    public void setLoginstreak(int loginstreak) {
        this.loginstreak = loginstreak;
    }

    public Date getNoTargetSince() {
        return noTargetSince;
    }

    public void setNoTargetSince(Date noTargetSince) {
        this.noTargetSince = noTargetSince;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getTargetDistance() {
        return targetDistance;
    }

    public void setTargetDistance(float targetDistance) {
        this.targetDistance = targetDistance;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @Column(name = "authorities")
    public String getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
