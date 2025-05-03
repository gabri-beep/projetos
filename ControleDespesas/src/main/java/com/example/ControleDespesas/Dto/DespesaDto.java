package com.example.ControleDespesas.Dto;

import com.example.ControleDespesas.Entity.Categoria;
import com.example.ControleDespesas.Entity.Despesa;
import com.example.ControleDespesas.Entity.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DespesaDto {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    private Categoria categoria;
    private Usuario usuario;

    public Despesa toDespesa(){
        return new Despesa(
                this.id,
                this.descricao,
                this.valor,
                this.data,
                this.categoria,
                this.usuario
        );
    }

    public DespesaDto fromDespesa(Despesa despesa){
        return new DespesaDto(
                despesa.getId(),
                despesa.getDescricao(),
                despesa.getValor(),
                despesa.getData(),
                despesa.getCategoria(),
                despesa.getUsuario()
        );
    }
}
