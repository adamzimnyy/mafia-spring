package adamzimny.controller.api;

import adamzimny.model.Code;
import adamzimny.model.Target;
import adamzimny.model.UserScore;
import adamzimny.service.ScoreService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by adamz on 04.11.2016.
 */
@Controller
@RequestMapping(value = "api/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<UserScore> getUserScore(@RequestParam("user") long id) {
      //TODO UserScore calculations
        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "top", method = RequestMethod.GET)
    public ResponseEntity<UserScore> getTop() {
        //TODO UserScore calculations
        return ResponseEntity.badRequest().body(null);
    }

}
