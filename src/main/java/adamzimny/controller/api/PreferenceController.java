package adamzimny.controller.api;

import adamzimny.model.Code;
import adamzimny.model.Preference;
import adamzimny.service.CodeService;
import adamzimny.service.PreferenceService;
import adamzimny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by adamz on 26.09.2016.
 */
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "admin/param")
public class PreferenceController {
    @Autowired
    PreferenceService preferenceService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestParam String key,@RequestParam String value) {
        preferenceService.save(key,value);
        return ResponseEntity.ok(null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> save(@RequestParam String key) {
      Optional<Preference> p =  preferenceService.get(key);
        return p.isPresent()? ResponseEntity.ok(p.get().getValue()) : ResponseEntity.badRequest().build();
    }
}
