package org.example.repository;

import org.example.models.Endereco;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class EnderecoRepository {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String ARQUIVO = "enderecos.json";

    public List<Endereco> carregarArquivo() {
        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(arquivo)) {
            Type tipoLista = new TypeToken<List<Endereco>>() {}.getType();
            List<Endereco> enderecos = gson.fromJson(reader, tipoLista);

            if (enderecos != null) {
                return enderecos;
            }else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + ARQUIVO, e);
        }
    }

    public void salvarEnderecos(List<Endereco> enderecos) {
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            writer.write(gson.toJson(enderecos));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo: " + ARQUIVO, e);
        }
    }
}
