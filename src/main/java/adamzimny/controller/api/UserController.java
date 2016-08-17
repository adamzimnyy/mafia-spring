package adamzimny.controller.api;

import adamzimny.model.User;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    public User get(@PathVariable long id){
        Optional<User> userOptional = userService.get(id);
        return userOptional.isPresent()? userOptional.get() : null;
    }
}
