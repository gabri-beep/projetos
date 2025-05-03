package com.example.ControleDespesas.Service;

import com.example.ControleDespesas.Dto.CategoriaDto;
import com.example.ControleDespesas.Entity.Categoria;
import com.example.ControleDespesas.Repository.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepo categoriaRepo;


    public List<Categoria> getAll(){
        return categoriaRepo.findAll();
    }

    public Optional<CategoriaDto> getById(Long id){
        Optional<Categoria> categoriaOptional = categoriaRepo.findById(id);
        if (categoriaOptional.isPresent()){
            CategoriaDto categoriaDto = new CategoriaDto();
            return Optional.of(categoriaDto.fromCategoria(categoriaOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    public CategoriaDto create(CategoriaDto categoriaDto){
        Categoria categoria = categoriaDto.toCategoria();
        categoria = categoriaRepo.save(categoria);
        return categoriaDto.fromCategoria(categoria);
    }

    public Optional<CategoriaDto> update(Long id, CategoriaDto categoriaDto){
        Optional<Categoria> categoriaOptional = categoriaRepo.findById(id);
        if (categoriaOptional.isPresent()){
            Categoria categoria = categoriaOptional.get();
            categoria.setNome(categoriaDto.getNome());
            return Optional.of(categoriaDto.fromCategoria(categoria));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if (categoriaRepo.existsById(id)){
            categoriaRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
