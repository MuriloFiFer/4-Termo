package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Maquina;
import java.util.ArrayList;
import java.util.List;

public class MaquinaAPI {

    /**
     * Método GET
     * 
     * Obtém uma lista de máquinas através de uma requisição GET para a API.
     * 
     * @return Uma lista de objetos `Maquina` recebidos da API.
     */
    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                    jsonObject.getString("id"),
                    jsonObject.getString("codigo"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("modelo"),
                    jsonObject.getString("fabricante"),
                    jsonObject.getString("dataAquisicao"),
                    jsonObject.getInt("tempoVidaEstimado"),
                    jsonObject.getString("localizacao"),
                    jsonObject.getString("detalhes"),
                    jsonObject.getString("manual")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    /**
     * Método POST
     * 
     * Envia uma nova máquina para a API utilizando uma requisição POST.
     * 
     * @param maquina O objeto `Maquina` que será enviado para a API.
     * @return A resposta da API após o envio da máquina.
     */
    public static String postMaquina(Maquina maquina) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codigo", maquina.getCodigo());
        jsonObject.put("nome", maquina.getNome());
        jsonObject.put("modelo", maquina.getModelo());
        jsonObject.put("fabricante", maquina.getFabricante());
        jsonObject.put("dataAquisicao", maquina.getDataAquisicao());
        jsonObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        jsonObject.put("localizacao", maquina.getLocalizacao());
        jsonObject.put("detalhes", maquina.getDetalhes());
        jsonObject.put("manual", maquina.getManual());

        String jsonInputString = jsonObject.toString();
        return ApiConnection.postData("maquinas", jsonInputString);
    }

    /**
     * Método PUT
     * 
     * Atualiza os dados de uma máquina existente na API utilizando uma requisição PUT.
     * 
     * @param id O ID da máquina que será atualizada.
     * @param maquina O objeto `Maquina` contendo os novos dados.
     * @return A resposta da API após a atualização da máquina.
     */
    public static String putMaquina(String id, Maquina maquina) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codigo", maquina.getCodigo());
        jsonObject.put("nome", maquina.getNome());
        jsonObject.put("modelo", maquina.getModelo());
        jsonObject.put("fabricante", maquina.getFabricante());
        jsonObject.put("dataAquisicao", maquina.getDataAquisicao());
        jsonObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        jsonObject.put("localizacao", maquina.getLocalizacao());
        jsonObject.put("detalhes", maquina.getDetalhes());
        jsonObject.put("manual", maquina.getManual());

        String jsonInputString = jsonObject.toString();
        return ApiConnection.putData("maquinas/" + id, jsonInputString);
    }
}
