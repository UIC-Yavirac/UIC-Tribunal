package uic.persona.feature.persona;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/persona")
@CrossOrigin({ "*" })


public class PersonaController {
    
    @Autowired
    CostumerPersona persona;

    @GetMapping("/")
    public List<PersonaDTO> findAll() {
        return persona.findAll();
    }

    @GetMapping("/{id}/")
    public PersonaDTO findById(@PathVariable Long id) {
        return persona.findById(id);
    }

    @PostMapping("/")
    public PersonaDTO save(@RequestBody PersonaDTO entity) {
        return persona.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        persona.deleteById(id);
    }

    @PutMapping("/{id}/")
    public PersonaDTO update(@PathVariable Long id, @RequestBody PersonaDTO entity) {
        return persona.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public PersonaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        PersonaDTO PersonaDTO = persona.findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            
            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                Field campoEntidad = PersonaDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(PersonaDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return persona.update(id, PersonaDTO);
    }
}

