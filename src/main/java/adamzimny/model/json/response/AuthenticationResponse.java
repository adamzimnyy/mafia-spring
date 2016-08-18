package adamzimny.model.json.response;


import adamzimny.model.User;

public class AuthenticationResponse {

    private static final long serialVersionUID = -6624726180748515507L;
    private String token;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token, User user) {
        this.setToken(token);
        this.setUser(user);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
