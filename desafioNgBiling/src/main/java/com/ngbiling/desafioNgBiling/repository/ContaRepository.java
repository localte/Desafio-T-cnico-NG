package com.ngbiling.desafioNgBiling.repository;

import com.ngbiling.desafioNgBiling.model.Conta;
import com.ngbiling.desafioNgBiling.repositoryInterface.ContaRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ContaRepository {

    ContaRepositoryInterface contaRepositoryInterface;

    @Autowired
    ContaRepository(ContaRepositoryInterface contaRepositoryInterface) {
        this.contaRepositoryInterface = contaRepositoryInterface;
    }

    public Conta createConta(Conta conta) throws Exception {
        if (findContaByNumeroConta(conta.getNumero_conta()) == null) {
            Conta tempConta = contaRepositoryInterface.save(conta);
            if (tempConta != null && tempConta.getNumero_conta() > 0) {
                return tempConta;
            }
            throw new DataRetrievalFailureException("Não foi possivel salvar a conta.");
        }
        throw new Exception("Já existe uma conta com este numero.");
    }

    public Conta findContaByNumeroConta(Integer numeroConta) {
        Optional<Conta> contaTemp = contaRepositoryInterface.findById(numeroConta);
        return contaTemp.orElse(null);
    }
}
