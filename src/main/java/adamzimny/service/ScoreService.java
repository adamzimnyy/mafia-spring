package adamzimny.service;

import adamzimny.repository.ScoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adamz on 04.11.2016.
 */
@Service
public class ScoreService {

    @Autowired
    ScoreDAO scoreDAO;
}
