package com.proyecveh.controller;

import com.proyecveh.domain.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyecveh.service.UsuarioService;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        
               
        return "index";
    }
    
    @GetMapping("/nuevoUsuario")
    public String nuevoUsuario(Usuario usuario){
        return "modificarUsuario";
    }
    
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/modificarUsuario/{idUsuario}")
    public String modificarUsuario(Usuario usuario, Model model){
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "modifica";
    }
    
    @GetMapping("/eliminarUsuario/{idUsuario}")
    public String eliminarUsuario(Usuario usuario){
        usuarioService.delete(usuario);
        return "redirect:/";
    }
}
