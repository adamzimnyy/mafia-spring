package adamzimny.controller.api;

import adamzimny.mapper.UserMapper;
import adamzimny.model.User;
import adamzimny.model.json.request.UserTemplate;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 2016-07-15.
 */
@EnableAutoConfiguration
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "api/user", params="id",method = RequestMethod.GET)
    public ResponseEntity<?> get(@RequestParam long id) {
        Optional<User> userOptional = userService.get(id);

        return userOptional.isPresent() ? ResponseEntity.ok(userOptional.get()) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "api/user", params="username",method = RequestMethod.GET)
    public ResponseEntity<?> getByUsername(@RequestParam String username) {
        Optional<User> userOptional = userService.get(username);
        return userOptional.isPresent() ? ResponseEntity.ok(userOptional.get()) : ResponseEntity.notFound().build();
    }


    @RequestMapping(value = "api/user", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam long id) {
        userService.delete(id);
        return ResponseEntity.ok(null);
    }


    @RequestMapping(value = "api/user/status", method = RequestMethod.PATCH)
    public ResponseEntity<?> changeStatus(@RequestParam("user") long id, @RequestParam("status") String status) {
        if ("active".equals(status) || "suspended".equals(status)) {
            Optional<User> userOptional = userService.get(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setStatus(status);
                userService.save(user);
                return ResponseEntity.ok(userOptional.get());
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "api/user", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateProfile(@RequestBody UserTemplate template) {

        Optional<User> userOptional = userService.get(template.getUsername());
        if (userOptional.isPresent()) {
            User user = UserMapper.map(userOptional.get(), template);
            userService.save(user);
        }
        return userOptional.isPresent() ? ResponseEntity.ok(userOptional.get()) : ResponseEntity.badRequest().body(null);
    }


    //============================    ADMIN    ========================================


    @RequestMapping(value = "admin/user/", method = RequestMethod.GET)
    public List<User> getAll(@RequestParam(value = "status", required = false) String status,
                             @RequestParam(value = "role", required = false) String role) {
        if (status == null && role == null)
            return userService.getAll();

        if (status != null && role == null)
            return userService.getByStatus(status);

        if (status == null)
            return userService.getByRole(role);

        return userService.getByStatusAndRole(status, role);
    }

    @RequestMapping(value = "admin/role", method = RequestMethod.PATCH)
    public ResponseEntity<?> role(@RequestParam("user") long id, @RequestParam("role") String role) {
      role = role.replace(" ","");
        if ("ROLE_USER".equals(role) || "ROLE_ADMIN".equals(role) || "ROLE_USER,ROLE_ADMIN".equals(role) || "ROLE_ADMIN,ROLE_USER".equals(role) ) {
            Optional<User> userOptional = userService.get(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setAuthorities(role);
                userService.save(user);
                return ResponseEntity.ok(userOptional.get());
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "admin/user/status", method = RequestMethod.PATCH)
    public ResponseEntity<?> ban(@RequestParam("user") long id, @RequestParam("status") String status) {
        if ("active".equals(status) || "banned".equals(status)) {
            Optional<User> userOptional = userService.get(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setStatus(status);
                userService.save(user);
                return ResponseEntity.ok(userOptional.get());
            }
        }
        return ResponseEntity.badRequest().body(null);
    }


}
