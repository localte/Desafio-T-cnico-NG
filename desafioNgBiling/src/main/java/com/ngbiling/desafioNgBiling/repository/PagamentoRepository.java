package com.ngbiling.desafioNgBiling.repository;

import com.ngbiling.desafioNgBiling.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PagamentoRepository {

    private final ContaRepository contaRepository;

    @Autowired
    PagamentoRepository(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta findContaByNumeroConta(Integer numero_conta) {
        return contaRepository.findContaByNumeroConta(numero_conta);
    }

    public Conta updateContaSaldoByConta(Conta conta, double novoSaldo) {
        return contaRepository.updateContaSaldoByConta(conta, novoSaldo);
    }
}
