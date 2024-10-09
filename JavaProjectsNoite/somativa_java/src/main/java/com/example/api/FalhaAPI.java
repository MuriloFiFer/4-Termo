package com.example.api;



import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Falhas;
import java.util.ArrayList;
import java.util.List;

public class FalhaAPI {

    public static List<Falhas> getFalhas() {
        String json = ApiConnection.getData("falhas"); // Supondo que você tenha um método que busca dados da API
        List<Falhas> falhas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falhas falha = new Falhas(
                    jsonObject.getString("id"),
                    jsonObject.getString("maquinaId"), // Corrigi para "maquinaId" para estar consistente com o model
                    jsonObject.getString("data"), // Alterando para LocalDate
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getString("tecnicoId"),
                    jsonObject.getString("observacoes")
                );
                falhas.add(falha);
            }
        }
        return falhas;
    }
}
