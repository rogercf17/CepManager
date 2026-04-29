package org.example.exception;

public class EnderecoNaoEncontrado extends RuntimeException {
    private String mensagem;

    public EnderecoNaoEncontrado(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
