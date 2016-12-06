package adamzimny.controller;


import adamzimny.model.User;
import adamzimny.model.json.request.AuthenticationRequest;
import adamzimny.model.json.response.AuthenticationResponse;
import adamzimny.security.MyUserDetails;
import adamzimny.security.TokenUtils;
import adamzimny.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the authentication
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = this.tokenUtils.generateToken(userDetails, device);
        Optional<User> user = userService.get(authenticationRequest.getUsername());

        // Return the token
        return ResponseEntity.ok(new AuthenticationResponse(token, user.get()));
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        MyUserDetails userDetails = (MyUserDetails) this.userDetailsService.loadUserByUsername(username);
        Optional<User> user = userService.get(username);
        if (user.isPresent() && this.tokenUtils.canTokenBeRefreshed(token, userDetails.getLastPasswordReset())) {
            String refreshedToken = this.tokenUtils.refreshToken(token);
            return ResponseEntity.ok(new AuthenticationResponse(refreshedToken, user.get()));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public ResponseEntity<?> getUserFromToken(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        System.out.println("username = " + username);
        Optional<User> user = userService.get(username);
        System.out.println("user found  = " + user.isPresent());
        System.out.println(user);
        if (user.isPresent()) {
            User u = user.get();
            u.setPassword("");
            return ResponseEntity.ok(u);
        } else
            return ResponseEntity.badRequest().body(null);
    }


    @RequestMapping(value = "password", method = RequestMethod.GET)
    public ResponseEntity<?> changePassword(@RequestParam("username") String username) {
        Optional<User> user = userService.get(username);
        //TODO send email with new password;
        return ResponseEntity.ok(null);
    }

}
