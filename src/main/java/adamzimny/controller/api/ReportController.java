package adamzimny.controller.api;

import adamzimny.model.Code;
import adamzimny.model.Report;
import adamzimny.model.User;
import adamzimny.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by adamz on 04.11.2016.
 */
@EnableAutoConfiguration
@Controller
public class ReportController {

    @Autowired
    ReportService reportService;
    @RequestMapping(value = "api/report", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Report code) {
        reportService.save(code);
        return ResponseEntity.ok(null);
    }


    //===========================    ADMIN    ====================================



    @RequestMapping(value = "admin/report/", method = RequestMethod.GET)
    public List<Report> getAll(@RequestParam(value = "by", required = false) User reportedBy,
                             @RequestParam(value = "reported", required = false) User reported,
                             @RequestParam(value = "reason", required = false) String reason) {
        //TODO 9 wariantów filtrowania
       return null;

    }

}
