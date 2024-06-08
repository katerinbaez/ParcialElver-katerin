package com.parcial.katerin.app.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/loginAdmin")
    public String adminLogin() {
        return "loginAdmin";
    }

    @GetMapping("/loginDirector")
    public String directorLogin() {
        return "loginDirector";
    }

    @GetMapping("/loginEst")
    public String estudLogin() { 
        return "loginEst";
    }

    @GetMapping("/loginEv")
    public String evaluaLogin() { 
        return "loginEv";
    }

    @GetMapping("/loginCoor")
    public String coordinadorLogin() { 
        return "loginCoor";
    }
}
