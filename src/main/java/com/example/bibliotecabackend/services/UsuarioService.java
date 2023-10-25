package com.example.bibliotecabackend.services;

import com.example.bibliotecabackend.models.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario obtenerPorId(Long id);
    public Usuario obtenerPorEmail(String email);
    public List<Usuario> obtenerPorNombre(String nombre);
    public List<Usuario> obtenerTodosLosUsuarios();
    public void guardarUsuario(Usuario usuarioGuardado);

    public Usuario obtenerPorEmailYClave(String email, String pass);
    public boolean existeEmailYClave(String email, String pass);

}
