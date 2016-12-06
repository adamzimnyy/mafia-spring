package adamzimny.service;

import adamzimny.model.Preference;
import adamzimny.repository.PreferenceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by adamz on 04.11.2016.
 */
@Service
public class PreferenceService {

    @Autowired
    PreferenceDAO preferenceDAO;

    public void save(String key, String value){
        Preference p = new Preference(key,value);
        preferenceDAO.save(p);
    }

    public Optional<Preference> get(String key) {
     return  preferenceDAO.findByKey(key);
    }
}
