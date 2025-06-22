package com.ngbiling.desafioNgBiling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Conta {
    @Id
    private int numero_conta;
    private float saldo;

}
