package uic.persona.feature.tribunal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/tribunals")
@CrossOrigin({ "*" }) 

public class TribunalController {

    @Autowired
    TribunalService tribunalService;

    @GetMapping("/{id}/")
    public Tribunal findById(@PathVariable Long id) {
        return tribunalService.findById(id);
    }

    @GetMapping("/")
    public List<Tribunal> findAll() {
        return tribunalService.findAll();
    }

    @PostMapping("/")
    public Tribunal save(@RequestBody Tribunal entity) {
        return tribunalService.save(entity);
    }

    @PutMapping("/{id}/")
    public Tribunal update(@RequestBody Tribunal entity) {
        return tribunalService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        tribunalService.deleteById(id);
    }

}
