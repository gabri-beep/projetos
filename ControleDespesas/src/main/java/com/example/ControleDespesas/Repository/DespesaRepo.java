package com.example.ControleDespesas.Repository;

import com.example.ControleDespesas.Entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepo extends JpaRepository<Despesa, Long> {
}
