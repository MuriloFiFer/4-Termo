package com.example.api;


import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.HistoricoManutencao;
import java.util.ArrayList;
import java.util.List;

public class HistoricoManutencaoAPI {

    public static List<HistoricoManutencao> getHistoricos() {
        String json = ApiConnection.getData("historicoManutencao"); // Supondo que você tenha um método que busca dados da API
        List<HistoricoManutencao> historicos = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                HistoricoManutencao historico = new HistoricoManutencao(
                    jsonObject.getString("id"),
                    jsonObject.getString("maquinaID"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getString("tecnicoID"),
                    jsonObject.getString("observacoes")
                );
                historicos.add(historico);
            }
        }
        return historicos;
    }
}
