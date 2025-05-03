package com.example.ControleDespesas.Dto;

import com.example.ControleDespesas.Entity.Despesa;
import com.example.ControleDespesas.Entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @JsonIgnore
    private List<Despesa> despesas;

    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.email,
                this.senha,
                this.despesas
        );
    }

    public UsuarioDto fromUsuario(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDespesas()
        );
    }

}
