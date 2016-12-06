package adamzimny.controller;

import adamzimny.mapper.UserMapper;
import adamzimny.model.User;
import adamzimny.model.json.request.UserTemplate;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by adamz on 17.08.2016.
 */
@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserTemplate userTemplate) {
        User user = UserMapper.map(userTemplate);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User u = userService.register(user);
        return ResponseEntity.ok().body(u);
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

    @RequestMapping(value = "/register/check",params="username", method = RequestMethod.GET)
    public boolean check(@RequestParam String username) {
        Optional<User> user = userService.get(username);
        return user == null || !user.isPresent();
    }

    @RequestMapping(value = "/register/check", params="email",method = RequestMethod.GET)
    public boolean checkEmail(@RequestParam("email") String email) {
        Optional<User> user = userService.getByEmail(email);
        return user == null || !user.isPresent();
    }
}
