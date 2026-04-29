package org.example.models;

public record EnderecoR(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String estado
) { }
