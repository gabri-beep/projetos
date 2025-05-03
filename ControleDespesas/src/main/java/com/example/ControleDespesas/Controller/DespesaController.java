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

    @PostMapping
    public ResponseEntity<DespesaDto> createDespesa(@RequestBody DespesaDto despesaDto){
        DespesaDto despesaDtoSave = despesaService.createDespesa(despesaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaDtoSave);
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
