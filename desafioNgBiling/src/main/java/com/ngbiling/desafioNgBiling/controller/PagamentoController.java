package com.ngbiling.desafioNgBiling.controller;

import com.ngbiling.desafioNgBiling.enums.TiposDePagamentosEnum;
import com.ngbiling.desafioNgBiling.model.Conta;
import com.ngbiling.desafioNgBiling.model.Transacao;
import com.ngbiling.desafioNgBiling.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    PagamentoService pagamentoService;

    @Autowired
    PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/transacao")
    public ResponseEntity transacao(@RequestBody Transacao transacao) {
        Conta conta;
        try {
            conta = pagamentoService.transacao(transacao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
}
