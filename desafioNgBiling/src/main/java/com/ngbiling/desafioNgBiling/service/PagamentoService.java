package com.ngbiling.desafioNgBiling.service;

import com.ngbiling.desafioNgBiling.enums.TiposDePagamentosEnum;
import com.ngbiling.desafioNgBiling.model.Conta;
import com.ngbiling.desafioNgBiling.model.Transacao;
import com.ngbiling.desafioNgBiling.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Conta transacao(Transacao transacao) throws Exception {
        if (transacao.getValor() < 0) {
            throw new Exception("Valor não pode ser negativo!");
        }

        Conta conta = pagamentoRepository.findContaByNumeroConta(transacao.getNumero_conta());

        if (conta == null) {
            throw new Exception("Conta não encontrada!");
        }

        double saldo = conta.getSaldo();
        double novoSaldo = saldo;
        double valor = transacao.getValor();
        TiposDePagamentosEnum tiposDePagamentosEnum = transacao.getTipo_de_pagamento();

        switch (tiposDePagamentosEnum) {
            case C:
                novoSaldo = transacaoPagamento(saldo, (valor * 1.05));
                break;
            case D:
                novoSaldo = transacaoPagamento(saldo, (valor * 1.03));
                break;
            case P:
                novoSaldo = transacaoPagamento(saldo, valor);
                break;
        }
        return pagamentoRepository.updateContaSaldoByConta(conta, novoSaldo);
    }

    private double transacaoPagamento(double saldo, double valor) throws Exception {
        if (saldo < valor) {
            throw new Exception("Conta não possui saldo suficiente!");
        }
        saldo -= valor;
        return saldo;
    }
}

