package com.ngbiling.desafioNgBiling.service;

import com.ngbiling.desafioNgBiling.model.Conta;
import com.ngbiling.desafioNgBiling.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {
    private ContaRepository contaRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta createConta(Conta conta) throws Exception {
        return contaRepository.createConta(conta);
    }

    public Conta findContaByNumeroConta(Integer numeroConta) {
        return contaRepository.findContaByNumeroConta(numeroConta);
    }
}
