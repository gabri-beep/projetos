package com.example.ControleDespesas.Repository;

import com.example.ControleDespesas.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}
