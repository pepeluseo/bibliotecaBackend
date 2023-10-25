package com.example.bibliotecabackend.repos;

import com.example.bibliotecabackend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepo  extends JpaRepository<Usuario, Integer> {
    public Usuario findByEmail(String email);
    public Usuario findById(Long id);
    public List<Usuario> findByNombre(String nombre);
    public Usuario findByEmailAndPass(String email, String pass);
    public boolean existsByEmailAndPass(String email, String pass);
}
