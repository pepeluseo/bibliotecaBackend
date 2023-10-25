package com.example.bibliotecabackend.controllers;

import com.example.bibliotecabackend.models.Usuario;
import com.example.bibliotecabackend.services.UsuarioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String pass,
            @RequestParam(defaultValue = "false") boolean mantener,
            HttpSession session,
           HttpServletResponse response,
            Model model

    ){
        System.out.println("correo: " + email);
        System.out.println("pass :" + pass);
        Usuario usuario = usuarioService.obtenerPorEmailYClave(email, pass);
        if (usuario != null){
            //usuario autentificado correctamente
            session.setAttribute("usuario", usuario);
            // Sí se seleccionó "Mantener mi sesión", establecer un tiempo de sesión más largo
            if (mantener){
                //Para que este siempre la sesión activa
                int maxAge = (7 * 24 * 60 * 60); // 7 días en segundos
                Cookie cookie = new Cookie("session", session.getId());
                cookie.setMaxAge(maxAge);
                response.addCookie(cookie);
            }
            return "redirect:/";

        } else {
            model.addAttribute("error", "Usuario y/o contraseña incorrectas");
            return "/vistas/login";
        }
    }
    @GetMapping("/todos")
    @ResponseBody
    public List<Usuario> obtenerTodos(){
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/vistas/login";
    }
}
