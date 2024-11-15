import 'package:flutter/material.dart';
import 'screens/task_list_page.dart';
import 'screens/task_create_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Prova SAEP',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      initialRoute: '/',
      routes: {
        '/': (context) => const TaskListPage(),
        '/create': (context) => const TaskCreatePage(),
      },
    );
  }
}
