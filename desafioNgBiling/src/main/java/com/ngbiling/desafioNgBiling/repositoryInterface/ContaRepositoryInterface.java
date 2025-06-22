package com.ngbiling.desafioNgBiling.repositoryInterface;

import com.ngbiling.desafioNgBiling.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepositoryInterface extends CrudRepository<Conta, Integer> {

}