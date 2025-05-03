package com.example.ControleDespesas.Controller;

import com.example.ControleDespesas.Dto.CategoriaDto;
import com.example.ControleDespesas.Entity.Categoria;
import com.example.ControleDespesas.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll(){
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> getById(@PathVariable Long id){
        Optional<CategoriaDto> categoriaDtoOptional = categoriaService.getById(id);
        if (categoriaDtoOptional.isPresent()){
            return ResponseEntity.ok(categoriaDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> create(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto categoriaDtoSave = categoriaService.create(categoriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDtoSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto){
        Optional<CategoriaDto> categoriaDtoOptional = categoriaService.update(id, categoriaDto);
        if (categoriaDtoOptional.isPresent()){
            return ResponseEntity.ok(categoriaDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (categoriaService.delete(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
