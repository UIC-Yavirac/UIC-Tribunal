package uic.persona.feature.tribunal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TribunalRepository extends CrudRepository<Tribunal, Long> {
    
    List<Tribunal> findAll();

}
