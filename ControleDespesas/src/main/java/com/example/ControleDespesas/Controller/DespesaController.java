package com.example.ControleDespesas.Controller;

import com.example.ControleDespesas.Dto.DespesaDto;
import com.example.ControleDespesas.Entity.Despesa;
import com.example.ControleDespesas.Service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public List<Despesa> getDespesasPorMesAno(
            @RequestParam(value = "mes", required = false) Integer mes,
            @RequestParam(value = "ano", required = false) Integer ano){
        if (mes == null && ano == null){
            return despesaService.getAll();
        }

        if (mes == null){
            mes = LocalDate.now().getMonthValue();
        }

        if (ano == null){
            ano = LocalDate.now().getYear();
        }

        return despesaService.getByMesAno(mes, ano);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDto> getById(@PathVariable Long id){
        Optional<DespesaDto> despesaDtoOptional = despesaService.getById(id);
        if (despesaDtoOptional.isPresent()){
            return ResponseEntity.ok(despesaDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DespesaDto> createDespesa(@RequestBody DespesaDto despesaDto){
        DespesaDto despesaDtoSave = despesaService.createDespesa(despesaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaDtoSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaDto> updateDespesa(@PathVariable Long id, DespesaDto despesaDto){
        Optional<DespesaDto> despesaDtoOptional = despesaService.getById(id);
        if (despesaDtoOptional.isPresent()){
            return ResponseEntity.ok(despesaDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (despesaService.delete(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
