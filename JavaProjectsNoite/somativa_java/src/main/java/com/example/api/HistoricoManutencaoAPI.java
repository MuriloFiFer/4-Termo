package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

public class HistoricoManutencaoAPI {

    // Define o endpoint da API
    private static final String ENDPOINT = "historicos"; // Substitua pelo endpoint correto

    public static void getHistoricos() {
        // Faz a requisição à API
        String response = ApiConnection.getData(ENDPOINT);
        
        if (response != null) {
            try {
                // Converte a resposta em um JSONArray se necessário
                JSONArray historicosArray = new JSONArray(response);
                
                for (int i = 0; i < historicosArray.length(); i++) {
                    JSONObject jsonObject = historicosArray.getJSONObject(i);
                    
                    // Verifica se a chave "maquinaID" existe
                    if (jsonObject.has("maquinaID")) {
                        String maquinaID = jsonObject.getString("maquinaID");
                        // Continue com a lógica utilizando o maquinaID
                        System.out.println("Máquina ID: " + maquinaID);
                    } else {
                        System.out.println("A chave 'maquinaID' não foi encontrada no JSON.");
                        // Trate o caso quando a chave não está presente
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro ao obter dados da API.");
        }
    }
}
