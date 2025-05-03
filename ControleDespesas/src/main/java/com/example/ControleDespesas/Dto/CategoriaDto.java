package com.example.ControleDespesas.Dto;

import com.example.ControleDespesas.Entity.Categoria;
import com.example.ControleDespesas.Entity.Despesa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Long id;
    private String nome;

    private List<Despesa> despesas;

    public Categoria toCategoria(){
        return new Categoria(this.id, this.nome, this.despesas);
    }

    public CategoriaDto fromCategoria(Categoria categoria){
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDespesas()
        );
    }
}
