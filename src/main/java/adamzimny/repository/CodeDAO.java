package adamzimny.repository;

import adamzimny.model.Code;
import adamzimny.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CodeDAO extends JpaRepository<Code,Integer> {
    List<Code> findByUserOrderByCreatedDesc(User wanted);
    List<Code> findByCreatedBefore(Date date);
}
