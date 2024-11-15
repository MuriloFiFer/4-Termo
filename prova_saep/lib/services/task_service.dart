import 'dart:convert';
import 'package:http/http.dart' as http;

class TaskService {
 static const String baseUrl = 'http://localhost:8000';

  // Função para buscar as tarefas
  Future<List<Map<String, dynamic>>> getTasks() async {
    try {
      final response = await http.get(Uri.parse('$baseUrl/tasks.php'));

      if (response.statusCode == 200) {
        List<dynamic> data = json.decode(response.body);
        return data.map((task) => task as Map<String, dynamic>).toList();
      } else {
        throw Exception('Falha ao carregar tarefas');
      }
    } catch (e) {
      rethrow;
    }
  }

  // Função para criar uma nova tarefa
  Future<void> createTask(String title, String description) async {
    try {
      final response = await http.post(
        Uri.parse('$baseUrl/tasks.php'),
        body: {
          'action': 'create',
          'title': title,
          'description': description,
        },
      );

      if (response.statusCode != 200) {
        throw Exception('Falha ao criar tarefa');
      }
    } catch (e) {
      rethrow;
    }
  }
}
