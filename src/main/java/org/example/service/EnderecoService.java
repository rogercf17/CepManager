package org.example.service;

import org.example.client.BuscadorDeCep;
import org.example.models.Endereco;
import org.example.repository.EnderecoRepository;
import java.util.List;

public class EnderecoService {
    private static final EnderecoRepository repository = new EnderecoRepository();
    private static final BuscadorDeCep buscadorDeCep = new BuscadorDeCep();

    public void listarEnderecos() {
        List<Endereco> enderecos = repository.carregarArquivo();

        if (enderecos.isEmpty()) {
            System.out.println("Nenhum endereço encontrado.");
            return;
        }else {
            System.out.println("Endereços encontrados:");
            for (Endereco endereco : enderecos) {
                System.out.println(endereco);
            }
        }
    }

    public void adicionarEndereco(String cep) {
        Endereco endereco = buscadorDeCep.BuscaCep(cep);

        if (endereco == null) {
            System.out.println("Nenhum endereço encontrado para o CEP: " + cep);
            return;
        }

        List<Endereco> enderecos = repository.carregarArquivo();

        if (enderecos.contains(endereco)) {
            System.out.println("Endereço já existe na lista!");
            return;
        }else {
            enderecos.add(endereco);
            repository.salvarEnderecos(enderecos);
            System.out.println("Endereço salvo com sucesso!");
        }
    }

    public void buscarEndereco(String cep) {
        List<Endereco> enderecos = repository.carregarArquivo();

        enderecos.stream()
                .filter(e -> e.getCep().equals(cep))
                .findFirst()
                .ifPresentOrElse(
                        endereco -> System.out.println("Endereço encontrado: " + endereco),
                        () -> System.out.println("CEP " + cep + " não encontrado na lista.")
                );
    }

    public void removerEndereco(String cep) {
        List<Endereco> enderecos = repository.carregarArquivo();

        boolean removido = enderecos.removeIf(endereco -> endereco.getCep().equals(cep));

        if (removido) {
            repository.salvarEnderecos(enderecos);
            System.out.println("Endereço com CEP " + cep + " removido com sucesso!");
        } else {
            System.out.println("CEP " + cep + " não encontrado na lista.");
        }
    }
}
