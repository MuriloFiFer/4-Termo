<?php
$host = 'localhost';        // Endereço do banco de dados (pode ser 'localhost' ou o IP do servidor)
$port = "5432";             // Porta do PostgreSQL (padrão é 5432)
$db   = 'provasaep';        // Nome do banco de dados
$user = 'postgres';         // Usuário do PostgreSQL
$pass = 'postgres';         // Senha do PostgreSQL
$charset = 'UTF8';          // Charset utilizado (para PostgreSQL, o padrão é 'UTF8')

// Configuração do DSN (Data Source Name)
$dsn = "pgsql:host=$host;port=$port;dbname=$db;options='--client_encoding=$charset'";

// Configuração de opções do PDO para melhorar a segurança
$options = [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,  // Exceções em caso de erro
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,         // Retorna como array associativo
    PDO::ATTR_EMULATE_PREPARES   => false,                    // Impede o uso de preparação emulado (melhor segurança)
];

try {
    // Criando a conexão PDO
    $pdo = new PDO($dsn, $user, $pass, $options);
    echo "Conexão com o banco de dados PostgreSQL realizada com sucesso!";
} catch (\PDOException $e) {
    // Em caso de erro, mostramos a mensagem de erro detalhada
    die("Erro na conexão com o banco de dados: " . $e->getMessage());
}
?>
