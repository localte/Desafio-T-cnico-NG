package com.ngbiling.desafioNgBiling.model;

import com.ngbiling.desafioNgBiling.enums.TiposDePagamentosEnum;
import lombok.Data;

@Data
public class Transacao {
    private int numero_conta;
    private TiposDePagamentosEnum tipo_de_pagamento;
    private double valor;
}
