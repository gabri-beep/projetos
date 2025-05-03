package com.example.ControleDespesas.Service;


import com.example.ControleDespesas.Dto.UsuarioDto;
import com.example.ControleDespesas.Entity.Usuario;
import com.example.ControleDespesas.Repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public List<Usuario> getAll(){
        return usuarioRepo.findAll();
    }

    public Optional<UsuarioDto> getById(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);
        if (usuarioOptional.isPresent()){
            UsuarioDto  usuarioDto = new UsuarioDto();
            return Optional.of(usuarioDto.fromUsuario(usuarioOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    public UsuarioDto createUsuario(UsuarioDto usuarioDto){
        Usuario usuario = usuarioDto.toUsuario();
        usuario = usuarioRepo.save(usuario);
        return usuarioDto.fromUsuario(usuario);
    }

    public Optional<UsuarioDto> updateUsuario(UsuarioDto usuarioDto, Long id){
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario  usuario = usuarioOptional.get();
            usuario.setNome(usuarioDto.getNome());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setSenha(usuarioDto.getSenha());
            return Optional.of(usuarioDto.fromUsuario(usuario));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if (usuarioRepo.existsById(id)){
            usuarioRepo.deleteById(id);
            return true;
        }  else {
            return false;
        }
    }

}
