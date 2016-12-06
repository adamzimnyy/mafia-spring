package adamzimny.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;


@Entity
public class Code {
    @Id
    @GeneratedValue
    Integer id;

    @OneToOne

    User user;
    String code;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    Date created;

    @OneToOne
    @Cascade(value = CascadeType.ALL)
    Location location;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }


        public static final class Builder {
            Integer id;
            User user;
            String codeString;
            Date created;
            Location location;

            private Builder() {
            }

            public static Builder create() {
                return new Builder();
            }

            public Builder withId(Integer id) {
                this.id = id;
                return this;
            }

            public Builder withUser(User user){
                this.user = user;
                return this;
            }

            public Builder withCode(String code) {
                this.codeString = code;
                return this;
            }

            public Builder withCreated(Date created) {
                this.created = created;
                return this;
            }

            public Builder withLocation(Location location) {
                this.location = location;
                return this;
            }

            public Code build() {
                Code code = new Code();
                code.setId(id);
                code.setUser(user);
                code.setCode(codeString);
                code.setCreated(created);
                code.setLocation(location);
                return code;
            }
        }
    }

