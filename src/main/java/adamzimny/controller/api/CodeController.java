package adamzimny.controller.api;

import adamzimny.model.Code;
import adamzimny.model.Location;
import adamzimny.model.User;
import adamzimny.service.CodeService;
import adamzimny.service.LocationService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by adamz on 26.09.2016.
 */
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "api/code")
public class CodeController {
    @Autowired
    CodeService codeService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Code code) {

        Optional<Code> old = codeService.getCodeForUser(code.getUser());
        if(old.isPresent()) codeService.delete(old.get());

        codeService.save(code);

        return ResponseEntity.ok(null);
    }
}
