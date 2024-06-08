package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.bd.Rol;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.bd.Usuario;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.repository.RolRepository;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    @Override
    public List<Usuario> listasDeUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioxId(Integer idusuario) {
        return usuarioRepository.findById(idusuario).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioXNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getActivo(),
                usuario.getIdusuario()
        );
    }
}
