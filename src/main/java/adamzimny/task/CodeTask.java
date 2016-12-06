package adamzimny.task;

import adamzimny.model.Code;
import adamzimny.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by adamz on 05.11.2016.
 */
@Component
public class CodeTask {

    private final
    CodeService codeService;

    @Autowired
    public CodeTask(CodeService codeService) {
        this.codeService = codeService;
    }

    //@Scheduled(fixedRate = 1000)
    public void deactiveOldCodes(){
        List<Code> list = codeService.getExpired();
        list.forEach(codeService::delete);
    }
}
