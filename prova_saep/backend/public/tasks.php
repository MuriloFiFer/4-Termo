<?php
// Incluindo a conexão com o banco de dados
include_once('../db.php');

// Definindo os headers para permitir o acesso de qualquer origem (CORS)
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
header('Access-Control-Allow-Headers: Content-Type');

// Verificação para requisições OPTIONS
if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    header('HTTP/1.1 200 OK');
    exit();
}

// Função para obter todas as tarefas
function getTasks($pdo) {
    $stmt = $pdo->query('SELECT * FROM tasks');
    return $stmt->fetchAll();
}

// Função para criar uma nova tarefa
function createTask($pdo, $title, $description) {
    $stmt = $pdo->prepare('INSERT INTO tasks (title, description) VALUES (?, ?)');
    $stmt->execute([$title, $description]);
    return $pdo->lastInsertId();
}

// Função para atualizar uma tarefa existente
function updateTask($pdo, $id, $title, $description) {
    $stmt = $pdo->prepare('UPDATE tasks SET title = ?, description = ? WHERE id = ?');
    $stmt->execute([$title, $description, $id]);
    return $stmt->rowCount();
}

// Função para deletar uma tarefa
function deleteTask($pdo, $id) {
    $stmt = $pdo->prepare('DELETE FROM tasks WHERE id = ?');
    $stmt->execute([$id]);
    return $stmt->rowCount();
}

// Tratando a requisição de acordo com o método HTTP
$method = $_SERVER['REQUEST_METHOD'];

switch ($method) {
    case 'GET':
        echo json_encode(getTasks($pdo));
        break;
    
    case 'POST':
        $data = json_decode(file_get_contents('php://input'), true);
        $id = createTask($pdo, $data['title'], $data['description']);
        echo json_encode(['id' => $id]);
        break;
    
    case 'PUT':
        $data = json_decode(file_get_contents('php://input'), true);
        updateTask($pdo, $data['id'], $data['title'], $data['description']);
        echo json_encode(['status' => 'success']);
        break;

    case 'DELETE':
        $data = json_decode(file_get_contents('php://input'), true);
        deleteTask($pdo, $data['id']);
        echo json_encode(['status' => 'deleted']);
        break;

    default:
        echo json_encode(['error' => 'Método não permitido']);
        break;
}
?>
