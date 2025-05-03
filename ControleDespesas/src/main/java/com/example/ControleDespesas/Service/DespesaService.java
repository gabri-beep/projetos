package com.example.ControleDespesas.Service;

import com.example.ControleDespesas.Dto.DespesaDto;
import com.example.ControleDespesas.Dto.UsuarioDto;
import com.example.ControleDespesas.Entity.Despesa;
import com.example.ControleDespesas.Entity.Usuario;
import com.example.ControleDespesas.Repository.DespesaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepo despesaRepo;

    //buscar todas as despesas
    public List<Despesa> getAll(){
        return despesaRepo.findAll();
    }

    public Optional<DespesaDto> getById(Long id){
        Optional<Despesa> despesaOptional = despesaRepo.findById(id);
        if (despesaOptional.isPresent()){
            DespesaDto despesaDto = new DespesaDto();
            return Optional.of(despesaDto.fromDespesa(despesaOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    // buscar despesas por mes e ano
    public List<Despesa> getByMesAno(int mes, int ano){
        LocalDate inicioDoMes = LocalDate.of(ano, mes, 1);
        LocalDate fimDoMes = inicioDoMes.withDayOfMonth(inicioDoMes.lengthOfMonth());

        return despesaRepo.findByDataBetween(inicioDoMes, fimDoMes);
    }

    // buscar despesas po ano sem considerar o mes
    public List<Despesa> getByAno(int ano){
        LocalDate inicioDoAno = LocalDate.of(ano, 1, 1);
        LocalDate fimDoAno = LocalDate.of(ano, 12, 31);

        return despesaRepo.findByDataBetween(inicioDoAno, fimDoAno);
    }

    // buscar despesas por mes considerando o mes atual e qualquer ano
    public List<Despesa> getByMes(int mes){
        int anoAtual = LocalDate.now().getYear();
        LocalDate inicioDoMes = LocalDate.of(anoAtual, mes, 1);
        LocalDate fimDoMes = inicioDoMes.withDayOfMonth(inicioDoMes.lengthOfMonth());

        return despesaRepo.findByDataBetween(inicioDoMes, fimDoMes);
    }

    public DespesaDto createDespesa(DespesaDto despesaDto){
        Despesa despesa = despesaDto.toDespesa();
        despesa = despesaRepo.save(despesa);
        return despesaDto.fromDespesa(despesa);
    }


    public boolean delete(Long id){
        if (despesaRepo.existsById(id)){
            despesaRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
