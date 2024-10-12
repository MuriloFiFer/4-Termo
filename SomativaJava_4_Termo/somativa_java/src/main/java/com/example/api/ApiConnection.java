package com.example.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {

    // Definição da URL base da API
    private static final String API_URL = "http://localhost:3000/";

    /**
     * Função GET
     * Faz uma requisição GET para a API e retorna a resposta como String.
     * 
     * @param endpoint O caminho do recurso da API que você deseja acessar.
     * @return A resposta da API como uma String.
     */
    public static String getData(String endpoint) {
        try {
            // Constrói a URL completa para a requisição
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obter o código de resposta
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Erro: Código de resposta " + responseCode);
                return null; // Ou trate de forma diferente, se necessário
            }

            // Lê a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            // Concatena cada linha da resposta em uma StringBuilder
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Fecha o BufferedReader e desconecta a conexão
            in.close();
            connection.disconnect();
            return content.toString();

        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição GET para " + endpoint + ": " + e.getMessage());
            e.printStackTrace(); // Mostra a pilha de erros
            return null;
        }
    }

    /**
     * Função POST
     * Envia dados para a API utilizando uma requisição POST e retorna a resposta.
     * 
     * @param endpoint O caminho do recurso da API.
     * @param jsonInputString Os dados no formato JSON que serão enviados.
     * @return A resposta da API como uma String.
     */
    public static String postData(String endpoint, String jsonInputString) {
        try {
            // Constrói a URL completa para a requisição
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true); // Permite o envio de dados no corpo da requisição

            // Escreve os dados JSON no corpo da requisição
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obter o código de resposta
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_CREATED) {
                System.out.println("Erro: Código de resposta " + responseCode);
                return null; // Ou trate de forma diferente, se necessário
            }

            // Lê a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();

            // Concatena cada linha da resposta em uma StringBuilder
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Fecha o BufferedReader e desconecta a conexão
            in.close();
            connection.disconnect();
            return content.toString();

        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição POST para " + endpoint + ": " + e.getMessage());
            e.printStackTrace(); // Mostra a pilha de erros
            return null;
        }
    }

    /**
     * Função PUT
     * Atualiza dados no servidor utilizando uma requisição PUT e retorna a resposta.
     * 
     * @param endpoint O caminho do recurso da API.
     * @param jsonInputString Os dados no formato JSON que serão atualizados.
     * @return A resposta da API como uma String.
     */
    public static String putData(String endpoint, String jsonInputString) {
        try {
            // Constrói a URL completa para a requisição
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true); // Permite o envio de dados no corpo da requisição

            // Escreve os dados JSON no corpo da requisição
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obter o código de resposta
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Erro: Código de resposta " + responseCode);
                return null; // Ou trate de forma diferente, se necessário
            }

            // Lê a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();

            // Concatena cada linha da resposta em uma StringBuilder
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Fecha o BufferedReader e desconecta a conexão
            in.close();
            connection.disconnect();
            return content.toString();

        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição PUT para " + endpoint + ": " + e.getMessage());
            e.printStackTrace(); // Mostra a pilha de erros
            return null;
        }
    }

    /**
     * Função DELETE
     * Remove um recurso no servidor utilizando uma requisição DELETE e retorna a resposta.
     * 
     * @param endpoint O caminho do recurso da API.
     * @return A resposta da API como uma String.
     */
    public static String deleteData(String endpoint) {
        try {
            // Constrói a URL completa para a requisição
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Accept", "application/json");

            // Obter o código de resposta
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Erro: Código de resposta " + responseCode);
                return null; // Ou trate de forma diferente, se necessário
            }

            // Lê a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();

            // Concatena cada linha da resposta em uma StringBuilder
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Fecha o BufferedReader e desconecta a conexão
            in.close();
            connection.disconnect();
            return content.toString();

        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição DELETE para " + endpoint + ": " + e.getMessage());
            e.printStackTrace(); // Mostra a pilha de erros
            return null;
        }
    }
}
