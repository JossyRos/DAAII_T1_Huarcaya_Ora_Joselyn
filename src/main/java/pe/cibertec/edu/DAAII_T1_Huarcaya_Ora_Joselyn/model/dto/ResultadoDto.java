package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultadoDto {
    private Boolean respuesta;
    private String mensaje;
}
