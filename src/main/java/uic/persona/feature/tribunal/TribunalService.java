package uic.persona.feature.tribunal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uic.persona.feature.persona.CostumerPersona;

@Service
public class TribunalService {

    @Autowired
    TribunalRepository tribunalRepository;
    @Autowired CostumerPersona costumerPersona;
  

    
    public Tribunal save(Tribunal entity){
        return tribunalRepository.save(entity);
    }

    public Tribunal findById( Long id){
        return tribunalRepository.findById(id).orElse(new Tribunal());
    }

    public void deleteById(Long id){
        tribunalRepository.deleteById(id);
    }

    public List<Tribunal> findAll(){
        return tribunalRepository.findAll();
    }

}
