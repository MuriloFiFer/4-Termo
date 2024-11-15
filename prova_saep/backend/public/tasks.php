<?php
// Incluindo a conexão com o banco de dados
include_once('../db.php');

// Definindo os headers para permitir o acesso de qualquer origem (CORS)
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');
header('Access-Control-Allow-Headers: Content-Type');

// Função para obter todas as tarefas
function getTasks($pdo) {
    $stmt = $pdo->query('SELECT * FROM tasks');  // Supondo que a tabela se chame 'tasks'
    return $stmt->fetchAll();  // Retorna todas as tarefas
}

// Função para criar uma nova tarefa
function createTask($pdo, $title, $description) {
    $stmt = $pdo->prepare('INSERT INTO tasks (title, description) VALUES (?, ?)');
    $stmt->execute([$title, $description]);
    return $pdo->lastInsertId();  // Retorna o ID da tarefa criada
}

// Função para atualizar uma tarefa existente
function updateTask($pdo, $id, $title, $description) {
    $stmt = $pdo->prepare('UPDATE tasks SET title = ?, description = ? WHERE id = ?');
    $stmt->execute([$title, $description, $id]);
    return $stmt->rowCount();  // Retorna a quantidade de linhas afetadas
}

// Função para deletar uma tarefa
function deleteTask($pdo, $id) {
    $stmt = $pdo->prepare('DELETE FROM tasks WHERE id = ?');
    $stmt->execute([$id]);
    return $stmt->rowCount();  // Retorna a quantidade de linhas afetadas
}

// Tratando a requisição de acordo com o método HTTP
$method = $_SERVER['REQUEST_METHOD'];

switch ($method) {
    case 'GET':
        // Quando for GET, retorna todas as tarefas
        echo json_encode(getTasks($pdo));
        break;
    
    case 'POST':
        // Quando for POST, cria uma nova tarefa
        $data = json_decode(file_get_contents('php://input'), true);  // Recebe o corpo da requisição
        $id = createTask($pdo, $data['title'], $data['description']);
        echo json_encode(['id' => $id]);
        break;
    
    case 'PUT':
        // Quando for PUT, atualiza uma tarefa existente
        $data = json_decode(file_get_contents('php://input'), true);
        updateTask($pdo, $data['id'], $data['title'], $data['description']);
        echo json_encode(['status' => 'success']);
        break;

    case 'DELETE':
        // Quando for DELETE, remove uma tarefa
        $data = json_decode(file_get_contents('php://input'), true);
        deleteTask($pdo, $data['id']);
        echo json_encode(['status' => 'deleted']);
        break;

    default:
        // Retorna erro para métodos não permitidos
        echo json_encode(['error' => 'Método não permitido']);
        break;
}
?>
