package com.example.ControleDespesas.Repository;

import com.example.ControleDespesas.Entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepo extends JpaRepository<Despesa, Long> {
    public List<Despesa> findByDataBetween(LocalDate inicio, LocalDate fim);
}
