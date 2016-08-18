package adamzimny.controller.api;

import adamzimny.model.User;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User get(@PathVariable long id){
        Optional<User> userOptional = userService.get(id);
        return userOptional.isPresent()? userOptional.get() : null;
    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll(){
          return userService.getAll();
    }

}
