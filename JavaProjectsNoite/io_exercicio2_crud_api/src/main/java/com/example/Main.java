package com.example;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do UsuarioController
        UsuarioController controller = new UsuarioController();

        // Cria um novo usuário
        Usuario novoUsuario = new Usuario("12", "Sophia", 23, "Rua das Rosas");
        controller.create(novoUsuario); // Adiciona o novo usuário

        // Cria outro usuário para atualizar
        Usuario atualizarUsuario = new Usuario("8f81", "Mario", 23, "Rua das Rosas");
        controller.deleteUser(atualizarUsuario); // Atualiza o usuário

        // Lê a lista de usuários após as operações
        controller.read(); // Mostra a lista de usuários
    }

    
}