package com.n1z0.customer_app.infra.gateway.zipCode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ViaCepAddress{
    private String cep;
    private String logradouro;
    private String uf;
    private String localidade;
    private String bairro;
}
