package uic.persona.feature.tribunal;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data 
public class Tribunal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private Date fecha;
    private Long personaId;
    // private Integer presidenteId;
    // private Integer vocal1Id;
    // private Integer vocal2Id;
    // private Integer suplenteId;
  
}