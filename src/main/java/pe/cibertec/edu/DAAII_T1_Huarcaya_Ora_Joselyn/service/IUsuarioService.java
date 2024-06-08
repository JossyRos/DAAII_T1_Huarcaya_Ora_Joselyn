package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.service;

import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listasDeUsuarios();
    Usuario buscarUsuarioxId(Integer idusuario);
    Usuario buscarUsuarioXNomUsuario(String nomusuario);
    Usuario registrarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);

}
