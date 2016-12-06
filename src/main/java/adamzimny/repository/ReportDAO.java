package adamzimny.repository;

import adamzimny.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * Created by adamz on 04.11.2016.
 */
@Repository
public interface ReportDAO extends JpaRepository<Report,Integer>{
}
