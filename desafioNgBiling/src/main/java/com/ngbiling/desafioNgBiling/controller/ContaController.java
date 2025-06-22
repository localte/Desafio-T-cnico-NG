package com.ngbiling.desafioNgBiling.controller;

import com.ngbiling.desafioNgBiling.model.Conta;
import com.ngbiling.desafioNgBiling.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {

    private ContaService contaService;

    @Autowired
    ContaController(ContaService contaService) {
        this.contaService = contaService;
    };

    @PostMapping("/conta")
    public ResponseEntity contaCreation(@RequestBody Conta conta) {
        try{
            contaService.createConta(conta);
        } catch (DataRetrievalFailureException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
       return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @GetMapping("/conta")
    public ResponseEntity<Conta> contaCreation(@RequestParam() Integer numero_conta) {
        Conta contaTemp = contaService.findContaByNumeroConta(numero_conta);
        if (contaTemp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaTemp);
    }
}
