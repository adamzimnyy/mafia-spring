package adamzimny.controller.web;

/**
 * Created by Adam on 2016-07-15.
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "Boxfuse") String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("greeting", "Hello " + name + "!");
        return result;
    }
}