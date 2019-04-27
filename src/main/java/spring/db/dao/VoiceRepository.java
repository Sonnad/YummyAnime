package spring.db.dao;

import org.springframework.data.repository.CrudRepository;
import spring.db.model.Voice;

/**
 * Created by Sonad on 29.11.17.
 */
public interface VoiceRepository extends CrudRepository<Voice, Integer>  {

    Voice findByName(String name);

}
