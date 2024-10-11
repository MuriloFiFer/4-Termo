package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Falhas;
import java.util.ArrayList;
import java.util.List;

public class FalhaAPI {

    /**
     * Método GET
     * 
     * Obtém uma lista de falhas através de uma requisição GET para a API.
     * O método faz a requisição, converte o JSON retornado em objetos `Falhas`,
     * e retorna uma lista desses objetos.
     * 
     * @return Uma lista de objetos `Falhas` recebidos da API.
     */
    public static List<Falhas> getFalhas() {
        List<Falhas> falhas = new ArrayList<>();
        
        // Faz uma requisição GET à API para obter os dados de falhas
        String json = ApiConnection.getData("falhas");
        
        // Verifica se a resposta JSON não é nula ou vazia
        if (json == null || json.isEmpty()) {
            System.out.println("Erro: Resposta da API é nula ou vazia.");
            return falhas; // Retorna uma lista vazia
        }

        try {
            // Converte a resposta JSON em uma lista de objetos Falhas
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                // Verifica se as chaves necessárias estão presentes
                String id = jsonObject.optString("id", "N/A"); // Use optString para evitar erro
                String maquinaId = String.valueOf(jsonObject.optInt("maquinaId", -1)); // Valor padrão se não encontrado
                String data = jsonObject.optString("data", "N/A");
                String tipo = jsonObject.optString("tipo", "N/A");
                String pecasTrocadas = jsonObject.optString("pecasTrocadas", "N/A");
                int tempoDeParada = jsonObject.optInt("tempoDeParada", 0); // Valor padrão se não encontrado
                String tecnicoId = jsonObject.optString("tecnicoId", "N/A");
                String observacoes = jsonObject.optString("observacoes", "N/A");
                
                // Cria uma nova instância de Falhas
                Falhas falha = new Falhas(id, maquinaId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);
                falhas.add(falha);
            }
        } catch (Exception e) {
            // Log do erro caso ocorra um problema ao parsear o JSON
            System.err.println("Erro ao processar a resposta JSON: " + e.getMessage());
        }
        
        return falhas;
    }

    /**
     * Método POST
     * 
     * Envia uma nova falha para a API utilizando uma requisição POST.
     * 
     * @param falha O objeto `Falhas` que será enviado para a API.
     * @return A resposta da API após o envio da falha.
     */
    public static String postFalha(Falhas falha) {
        // Constrói um JSON com os dados da falha
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", falha.getMaquinaID());
        jsonObject.put("data", falha.getData());
        jsonObject.put("tipo", falha.getTipo());
        jsonObject.put("pecasTrocadas", falha.getPecasTrocadas());
        jsonObject.put("tempoDeParada", falha.getTempoDeParada());
        jsonObject.put("tecnicoId", falha.getTecnicoID());
        jsonObject.put("observacoes", falha.getObservacoes());

        // Envia os dados da falha para a API usando o método POST
        String jsonInputString = jsonObject.toString();
        return ApiConnection.postData("falhas", jsonInputString);
    }

    /**
     * Método PUT
     * 
     * Atualiza os dados de uma falha existente na API utilizando uma requisição PUT.
     * 
     * @param id O ID da falha que será atualizada.
     * @param falha O objeto `Falhas` contendo os novos dados.
     * @return A resposta da API após a atualização da falha.
     */
    public static String putFalha(String id, Falhas falha) {
        // Constrói um JSON com os novos dados da falha
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaID", falha.getMaquinaID());
        jsonObject.put("data", falha.getData());
        jsonObject.put("tipo", falha.getTipo());
        jsonObject.put("pecasTrocadas", falha.getPecasTrocadas());
        jsonObject.put("tempoDeParada", falha.getTempoDeParada());
        jsonObject.put("tecnicoId", falha.getTecnicoID());
        jsonObject.put("observacoes", falha.getObservacoes());

        // Envia os dados atualizados para a API usando o método PUT
        String jsonInputString = jsonObject.toString();
        return ApiConnection.putData("falhas/" + id, jsonInputString);
    }
}
