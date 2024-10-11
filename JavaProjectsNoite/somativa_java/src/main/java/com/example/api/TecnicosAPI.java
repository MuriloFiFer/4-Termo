package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Tecnicos;
import java.util.ArrayList;
import java.util.List;

public class TecnicosAPI {

    /**
     * Método GET
     * 
     * Obtém uma lista de técnicos através de uma requisição GET para a API.
     * O método faz a requisição, converte o JSON retornado em objetos `Tecnicos`,
     * e retorna uma lista desses objetos.
     * 
     * @return Uma lista de objetos `Tecnicos` recebidos da API.
     */
    public static List<Tecnicos> getTecnicos() {
        List<Tecnicos> tecnicos = new ArrayList<>();
        try {
            // Faz uma requisição GET à API para obter os dados dos técnicos
            String json = ApiConnection.getData("tecnicos");

            if (json != null) {
                // Converte a resposta JSON em uma lista de objetos Tecnicos
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Tecnicos tecnico = new Tecnicos(
                        jsonObject.getString("id"),
                        jsonObject.has("maquinaID") ? jsonObject.getString("maquinaID") : null, // Verifica se "maquinaID" está presente
                        jsonObject.getString("data"),
                        jsonObject.getString("tipo"),
                        jsonObject.getString("pecasTrocadas"),
                        jsonObject.getInt("tempoDeParada"),
                        jsonObject.getString("tecnicoID"),
                        jsonObject.getString("observacoes")
                    );
                    tecnicos.add(tecnico);
                }
            } else {
                System.out.println("Erro ao obter dados da API: resposta nula.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar a requisição: " + e.getMessage());
        }
        return tecnicos;
    }

    /**
     * Método POST
     * 
     * Envia um novo técnico para a API utilizando uma requisição POST.
     * 
     * @param tecnico O objeto `Tecnicos` que será enviado para a API.
     * @return A resposta da API após o envio do técnico.
     */
    public static String postTecnico(Tecnicos tecnico) {
        if (tecnico == null) {
            return "Técnico não pode ser nulo.";
        }
        
        // Verificações adicionais para os dados do técnico podem ser feitas aqui
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaID", tecnico.getMaquinaID());
        jsonObject.put("data", tecnico.getData());
        jsonObject.put("tipo", tecnico.getTipo());
        jsonObject.put("pecasTrocadas", tecnico.getPecasTrocadas());
        jsonObject.put("tempoDeParada", tecnico.getTempoDeParada());
        jsonObject.put("tecnicoID", tecnico.getTecnicoID());
        jsonObject.put("observacoes", tecnico.getObservacoes());

        // Envia os dados do técnico para a API usando o método POST
        String jsonInputString = jsonObject.toString();
        return ApiConnection.postData("tecnicos", jsonInputString);
    }

    /**
     * Método PUT
     * 
     * Atualiza os dados de um técnico existente na API utilizando uma requisição PUT.
     * 
     * @param id O ID do técnico que será atualizado.
     * @param tecnico O objeto `Tecnicos` contendo os novos dados.
     * @return A resposta da API após a atualização do técnico.
     */
    public static String putTecnico(String id, Tecnicos tecnico) {
        if (tecnico == null) {
            return "Técnico não pode ser nulo.";
        }

        // Constrói um JSON com os novos dados do técnico
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaID", tecnico.getMaquinaID());
        jsonObject.put("data", tecnico.getData());
        jsonObject.put("tipo", tecnico.getTipo());
        jsonObject.put("pecasTrocadas", tecnico.getPecasTrocadas());
        jsonObject.put("tempoDeParada", tecnico.getTempoDeParada());
        jsonObject.put("tecnicoID", tecnico.getTecnicoID());
        jsonObject.put("observacoes", tecnico.getObservacoes());

        // Envia os dados atualizados para a API usando o método PUT
        String jsonInputString = jsonObject.toString();
        return ApiConnection.putData("tecnicos/" + id, jsonInputString);
    }
}
