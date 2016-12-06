package adamzimny.service;

import adamzimny.constant.Preferences;
import adamzimny.model.Code;
import adamzimny.model.User;
import adamzimny.repository.CodeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by adamz on 26.09.2016.
 */
@Service
public class CodeService {

    private final CodeDAO codeDAO;

    @Autowired
    public CodeService(CodeDAO codeDAO) {
        this.codeDAO = codeDAO;
    }

    public Code save(Code code) {
        return codeDAO.save(code);
    }

    public Optional<Code> getCodeForUser(User wanted) {
        List<Code> list = codeDAO.findByUserOrderByCreatedDesc(wanted);
        if (!list.isEmpty()) return Optional.ofNullable(list.get(0));
        return Optional.empty();
    }

    public List<Code> getExpired() {
        LocalDateTime timeAge = LocalDateTime.now().minus(Preferences.CODE_EXPIRY_TIME, ChronoUnit.MINUTES);
        return codeDAO.findByCreatedBefore(Date.from(timeAge.atZone(ZoneId.systemDefault()).toInstant()));
    }

    public void delete(Code code) {
        codeDAO.delete(code);
    }
}
