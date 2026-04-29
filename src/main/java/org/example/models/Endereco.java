package org.example.models;

import java.util.Objects;

public class Endereco {
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(EnderecoR dto) {
        this.cep = dto.cep();
        this.rua = dto.logradouro();
        this.bairro = dto.bairro();
        this.cidade = dto.localidade();
        this.estado = dto.estado();
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Endereco {" +
                "CEP='" + cep + '\'' +
                ", Rua='" + rua + '\'' +
                ", Bairro='" + bairro + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", Estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cep);
    }
}
