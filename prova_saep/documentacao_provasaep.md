
# Documentação do Projeto - ProvaSAEP

## Visão Geral

O projeto **ProvaSAEP** é uma aplicação web utilizando Flutter para o frontend, PHP (Laravel ou tradicional) para o backend, e PostgreSQL como banco de dados. Este documento descreve a estrutura do projeto, funcionalidades, tecnologias utilizadas e os fluxos principais da aplicação.

## Tecnologias Utilizadas

- **Frontend**: Flutter (Dart)
- **Backend**: PHP com PDO (PostgreSQL)
- **Banco de Dados**: PostgreSQL
- **Servidor**: Servidor Local
- **Ferramentas**: Visual Studio Code, Postman, PHPMyAdmin (para PostgreSQL)

## Funcionalidades

- **Gerenciamento de Tarefas**: A aplicação permite criar, listar, atualizar e excluir tarefas.
- **Comunicação com o Backend**: A comunicação entre o frontend (Flutter) e o backend (PHP) é feita por meio de chamadas HTTP (GET, POST, PUT, DELETE).
- **Banco de Dados**: O PostgreSQL é utilizado para armazenar as tarefas.

## Arquitetura

A arquitetura do projeto segue o modelo **Client-Server**, onde o Flutter atua como o cliente, e o PHP serve como o servidor que se comunica com o banco de dados PostgreSQL. O diagrama abaixo ilustra a interação entre os componentes:

```plaintext
+--------------------+       +-------------------+       +-----------------------+
|     Flutter        | <---> |      Backend      | <---> |  Banco de Dados       |
|   (Frontend)       |       |   (PHP - API)     |       |    (PostgreSQL)       |
+--------------------+       +-------------------+       +-----------------------+
```

## Como Rodar o Projeto Localmente

1. **Backend**: Para rodar o backend, execute o arquivo `tasks.php` no servidor Apache ou PHP local. Verifique se o Apache está configurado corretamente para executar o PHP. O backend deve estar rodando em `http://localhost/prova_saep/backend/public`.
2. **Frontend**: Execute a aplicação Flutter com o comando `flutter run`. Verifique se as dependências estão corretamente instaladas antes de rodar o Flutter.
3. **Banco de Dados**: A configuração do banco de dados PostgreSQL deve ser feita corretamente. Use o seguinte código de configuração para o arquivo de conexão (db.php):

```php
<?php
$host = 'localhost'; 
$port = "5432"; 
$db = 'provasaep'; 
$user = 'postgres'; 
$pass = 'postgres'; 
$charset = 'UTF8';

$dsn = "pgsql:host=$host;port=$port;dbname=$db;options='--client_encoding=$charset'";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES => false,
];

try {
    $pdo = new PDO($dsn, $user, $pass, $options);
} catch (\PDOException $e) {
    die("Erro na conexão com o banco de dados: " . $e->getMessage());
}
?>
```

## Fluxo de Funcionalidades

### 1. Criar Tarefa
- **Método**: `POST`
- **Endpoint**: `/tasks.php`
- **Parâmetros**:
  - `title`: Título da tarefa
  - `description`: Descrição da tarefa

### 2. Obter Tarefas
- **Método**: `GET`
- **Endpoint**: `/tasks.php`
- **Retorno**: Lista de tarefas em formato JSON

### 3. Atualizar Tarefa
- **Método**: `PUT`
- **Endpoint**: `/tasks.php`
- **Parâmetros**:
  - `id`: ID da tarefa
  - `title`: Novo título
  - `description`: Nova descrição

### 4. Excluir Tarefa
- **Método**: `DELETE`
- **Endpoint**: `/tasks.php`
- **Parâmetros**:
  - `id`: ID da tarefa a ser excluída

## SMART Goals

### S - Specific (Específico)
A aplicação deve permitir que o usuário crie, visualize, edite e exclua tarefas de forma eficiente, com integração entre o frontend Flutter e o backend PHP.

### M - Measurable (Mensurável)
- Criar, listar, atualizar e excluir tarefas devem funcionar corretamente.
- Respostas da API devem ter status code 200 (sucesso) para operações bem-sucedidas.

### A - Achievable (Atingível)
As funcionalidades descritas já foram implementadas, com comunicação entre frontend e backend sendo realizada via HTTP.

### R - Relevant (Relevante)
A aplicação é relevante para gerenciar tarefas de forma simples e eficiente, utilizando tecnologias modernas.

### T - Time-based (Baseado no Tempo)
A aplicação pode ser completamente implementada e testada em um prazo de 2 a 3 semanas.

## Conclusão

Este projeto implementa um sistema simples de gerenciamento de tarefas, com uma arquitetura cliente-servidor e comunicação entre o frontend em Flutter e o backend em PHP. O uso do PostgreSQL como banco de dados garante robustez e escalabilidade.

## Como Contribuir

1. Fork o repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`).
3. Faça suas alterações e commit (`git commit -am 'Adicionando nova feature'`).
4. Envie para o repositório remoto (`git push origin feature/MinhaFeature`).
5. Abra um Pull Request.
