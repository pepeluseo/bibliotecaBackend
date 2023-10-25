package com.example.bibliotecabackend.services;

import com.example.bibliotecabackend.models.Usuario;
import com.example.bibliotecabackend.repos.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepo usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }
    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public Usuario obtenerPorEmail(String email) {
        return usuarioRepo.findByEmail(email);
    }

    @Override
    public List<Usuario> obtenerPorNombre(String nombre) {
        return usuarioRepo.findByNombre(nombre);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuarioGuardado) {
        usuarioRepo.save(usuarioGuardado);

    }

    @Override
    public Usuario obtenerPorEmailYClave(String email, String pass) {
        return usuarioRepo.findByEmailAndPass(email, pass);
    }

    @Override
    public boolean existeEmailYClave(String email, String pass) {
        return usuarioRepo.existsByEmailAndPass(email,pass);
    }
}
