package com.example.ControleDespesas.Repository;

import com.example.ControleDespesas.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
}
