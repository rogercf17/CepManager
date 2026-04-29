package org.example.client;

import org.example.exception.EnderecoNaoEncontrado;
import org.example.models.Endereco;
import org.example.models.EnderecoR;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorDeCep {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    private final HttpClient client = HttpClient.newHttpClient();


    public Endereco BuscaCep(String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            if (json.contains("\"erro\": true")) {
                throw new EnderecoNaoEncontrado(cep);
            }

            EnderecoR enderecoR = gson.fromJson(json, EnderecoR.class);
            Endereco endereco = new Endereco(enderecoR);
            return endereco;
        }catch (EnderecoNaoEncontrado e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar CEP: " + cep, e);
        }
    }
}
