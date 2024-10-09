package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Tecnicos;
import java.util.ArrayList;
import java.util.List;

public class TecnicosAPI {

    public static List<Tecnicos> getTecnicos() {
        String json = ApiConnection.getData("tecnicos"); // Pegando dados dos técnicos via API
        List<Tecnicos> tecnicos = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tecnicos tecnico = new Tecnicos(
                    jsonObject.getString("id"),
                    jsonObject.getString("maquinaID"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getString("tecnicoID"),
                    jsonObject.getString("observacoes")
                );
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }
}
