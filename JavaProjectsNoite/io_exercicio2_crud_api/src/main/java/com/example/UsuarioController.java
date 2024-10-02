package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public void read() {
        try {
            // Define a URL da API que será acessada
            url = new URL("http://localhost:3000/usuarios");
            // Abre uma conexão HTTP com a URL especificada
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Define o método de requisição como GET
            con.setRequestMethod("GET");

            // Obtém o código de resposta da requisição
            int status = con.getResponseCode();
            // Verifica se a resposta é 200 (OK). Caso contrário, lança uma exceção
            if (status != 200) {
                throw new Exception("Erro de conexão: " + status);
            }

            // Cria um BufferedReader para ler a resposta da API
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // StringBuilder para construir a resposta em formato de string
            StringBuilder conteudo = new StringBuilder();
            String linha;

            // Lê cada linha da resposta e a adiciona ao StringBuilder
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
            }
            // Fecha o BufferedReader
            br.close();

            // Converter o conteúdo para dados da classe Usuario
            JSONArray dadosUsuarios = new JSONArray(conteudo.toString());
            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuarioJson.getString("id"),
                        usuarioJson.getString("nome"),
                        usuarioJson.getInt("idade"),
                        usuarioJson.getString("endereco")));
            }
            // Imprime a lista de usuários no console
            System.out.println(usuarios.toString());

        } catch (Exception e) {
            // Tratamento de exceções com stack trace
            e.printStackTrace();
        }
    }

    public void create(Usuario usuario) {
        try {
            // Define a URL da API que será acessada
            url = new URL("http://localhost:3000/usuarios");
            // Abre uma conexão HTTP com a URL especificada
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Define o método de requisição como POST
            con.setRequestMethod("POST");
            // Configura as propriedades da conexão
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true); // Permite envio de dados

            // Cria o JSON a ser enviado
            JSONObject usuarioJson = new JSONObject();
            
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            // Envia o JSON
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = usuarioJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém o código de resposta da requisição
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // Verifica se o status é 201 (Created)
                throw new Exception("Erro ao criar usuario: " + status);
            }

            // Lê a resposta da API (opcional, dependendo do que você quer fazer)
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                response.append(linha.trim());
            }
            br.close();

            // Exibe a resposta no console
            System.out.println("Usuário criado: " + response.toString());

        } catch (Exception e) {
            // Tratamento de exceções
            e.printStackTrace();
        }
    }
    public void updateUser(Usuario usuario) {
        try {
            url = new URL("http://localhost:3000/usuarios/" + usuario.getId());
            // Abre uma conexão HTTP com a URL especificada
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Define o método de requisição como PUT
            con.setRequestMethod("PUT");
            // Configura as propriedades da conexão
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true); // Permite envio de dados
            // Cria o JSON a ser enviado
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("id", usuario.getId());
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            // Envia o JSON
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = usuarioJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            // Obtém o código de resposta da requisição
            int status = con.getResponseCode();
            if (status != 200) { // Verifica se o status é 201 (Created)
                throw new Exception("Erro ao atualizar usuario: " + status);
            }

                
            System.out.println("Usuário com ID " + usuario.getId() + " atualizado com sucesso.");
            read();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void deleteUser(Usuario usuario) {
        HttpURLConnection con = null;
        try {
            // Monta a URL corretamente
            URL url = new URL("http://localhost:3000/usuarios/" + usuario.getId());
            con = (HttpURLConnection) url.openConnection();
            
            // Define o método de requisição como DELETE
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Accept", "application/json");
            
            // Obtém o código de resposta da requisição
            int status = con.getResponseCode();
            if (status!=200 && status != 204) { // Verifica se o status é 204 (No Content)
                throw new Exception("Erro ao deletar usuario: " + status);
            }
            
            System.out.println("Usuário com ID " + usuario.getId() + " deletado com sucesso.");
            read();
    
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace(); // Para facilitar o diagnóstico
        } finally {
            if (con != null) {
                con.disconnect(); // Fecha a conexão
            }
        }

}
}