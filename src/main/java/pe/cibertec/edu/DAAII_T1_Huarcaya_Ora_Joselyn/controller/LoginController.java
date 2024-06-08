package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.bd.Usuario;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.service.UsuarioService;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class LoginController {

    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(){
        return "auth/frmlogin";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/registrar")
    public String registrar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "auth/registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "auth/registrar";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nomusuario = auth.getName();
        Usuario usuario = usuarioService.buscarUsuarioXNomUsuario(nomusuario);
        model.addAttribute("nomusuario", usuario.getNomusuario());
        return "layout";
    }

}
