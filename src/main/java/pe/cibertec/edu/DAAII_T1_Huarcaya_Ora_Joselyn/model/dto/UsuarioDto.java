package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
}

