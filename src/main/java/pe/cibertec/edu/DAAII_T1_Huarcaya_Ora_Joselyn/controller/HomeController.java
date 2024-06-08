package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/inicio")
    public String inicio(){

        return "inicio";
    }
}
