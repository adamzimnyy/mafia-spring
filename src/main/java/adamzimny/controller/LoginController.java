package adamzimny.controller;

import adamzimny.dto.UserDTO;
import adamzimny.model.User;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adam on 2016-07-15.
 */
@RestController
@EnableAutoConfiguration
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value ="login", method = RequestMethod.POST)
    public void login(){

    }

    @RequestMapping(value ="register", method = RequestMethod.POST)
    public ResponseEntity<String> register(User user){
    userService.save(user);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}
