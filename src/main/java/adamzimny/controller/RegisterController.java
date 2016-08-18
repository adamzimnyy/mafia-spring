package adamzimny.controller;

import adamzimny.model.User;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by adamz on 17.08.2016.
 */
@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User user) {
        
        userService.register(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "register/{username}/{password}", method = RequestMethod.GET)
    public ResponseEntity<String> registerGet(@PathVariable String username, @PathVariable String password) {
        User user = new User();
        user.setUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setPassword(passwordEncoder.encode(password));

        userService.register(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
