package com.example.ControleDespesas.Service;


import com.example.ControleDespesas.Dto.UsuarioDto;
import com.example.ControleDespesas.Entity.Usuario;
import com.example.ControleDespesas.Repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public UsuarioDto createUsuario(UsuarioDto usuarioDto){
        Usuario usuario = usuarioDto.toUsuario();
        usuario = usuarioRepo.save(usuario);
        return usuarioDto.fromUsuario(usuario);
    }
}
