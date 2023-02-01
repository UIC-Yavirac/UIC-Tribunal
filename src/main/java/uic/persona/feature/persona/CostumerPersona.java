package uic.persona.feature.persona;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "bff.customer", url = "http://localhost:8000/api/persona")
public interface CostumerPersona {

    @GetMapping("/{id}/")
    PersonaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<PersonaDTO> findAll();

    @PostMapping("/")
    PersonaDTO save(PersonaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    PersonaDTO update(@PathVariable("id") Long id, PersonaDTO entity);

    @PutMapping("/{id}/completardatos/")
    PersonaDTO completardatos(@PathVariable("id") Long id);
}




