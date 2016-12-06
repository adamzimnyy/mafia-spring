package adamzimny.service;

import adamzimny.model.Report;
import adamzimny.repository.ReportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adamz on 04.11.2016.
 */
@Service
public class ReportService {

    @Autowired
    ReportDAO reportDAO;

    public void save(Report report) {
        reportDAO.save(report);
    }
}
