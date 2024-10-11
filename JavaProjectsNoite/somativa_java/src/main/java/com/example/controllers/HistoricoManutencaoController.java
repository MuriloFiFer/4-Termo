package com.example.controllers;

import com.example.api.ApiConnection;
import com.example.models.HistoricoManutencao; // Certifique-se de que a classe está importada
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HistoricoManutencaoController {

    private static final String ENDPOINT = "historicos"; // Ajuste para o endpoint correto

    public static List<HistoricoManutencao> getHistoricos() {
        List<HistoricoManutencao> historicos = new ArrayList<>();
        
        // Faz a requisição à API
        String response = ApiConnection.getData(ENDPOINT);
        
        if (response != null) {
            try {
                JSONArray historicosArray = new JSONArray(response);
                
                for (int i = 0; i < historicosArray.length(); i++) {
                    JSONObject jsonObject = historicosArray.getJSONObject(i);
                    
                    if (jsonObject.has("maquinaID")) {
                        String id = jsonObject.optString("id"); // Supondo que o ID vem da API
                        String maquinaID = jsonObject.getString("maquinaID");
                        String data = jsonObject.getString("data"); // Pode ser ajustado conforme o formato recebido
                        String tipo = jsonObject.optString("tipo"); // Adicione conforme necessário
                        String pecasTrocadas = jsonObject.optString("pecasTrocadas"); // Adicione conforme necessário
                        int tempoDeParada = jsonObject.optInt("tempoDeParada", 0); // Default para 0 se não existir
                        String tecnicoID = jsonObject.optString("tecnicoID"); // Adicione conforme necessário
                        String observacoes = jsonObject.optString("observacoes"); // Adicione conforme necessário
                        
                        // Crie um objeto HistoricoManutencao e adicione à lista
                        HistoricoManutencao historico = new HistoricoManutencao(id, maquinaID, data, tipo, pecasTrocadas, tempoDeParada, tecnicoID, observacoes);
                        historicos.add(historico);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro ao obter dados da API.");
        }
        
        return historicos; // Retorne a lista
    }

    public List<HistoricoManutencao> readHistorico() {
        // Chame o método getHistoricos() para obter a lista de históricos
        return getHistoricos(); // Retorna a lista de históricos obtida da API
    }
}
