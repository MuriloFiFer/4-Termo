import 'package:flutter/material.dart';

// Função principal que inicializa o app.
void main() {
  runApp(const MyApp());
}

// Widget principal da aplicação, sem estado (StatelessWidget).
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // O MaterialApp é o widget base da aplicação, define título, tema e a tela inicial (home).
    return MaterialApp(
      title: 'Flutter Navigation',  // Título da aplicação.
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),  // Definição de tema baseado em um 
        //esquema de cores.
        useMaterial3: true,  // Usando Material Design 3.
      ),
      home: const HomePage(),  // Define a HomePage como a tela inicial.
    );
  }
}

// Widget HomePage, que será a primeira tela mostrada ao usuário.
class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    // Scaffold fornece a estrutura visual básica, como AppBar e corpo (body).
    return Scaffold(
      appBar: AppBar(
        title: const Text('Home Page'),  // Define o título da AppBar.
      ),
      body: Center(
        child: ElevatedButton(
          // Ação executada ao pressionar o botão.
          onPressed: () {
            Navigator.push(
              // Navega para a SecondPage ao clicar no botão.
              context,
              MaterialPageRoute(builder: (context) => const SecondPage()),
            );
          },
          child: const Text('Ir para a Segunda Página'),  // Texto do botão.
        ),
      ),
    );
  }
}

// Widget SecondPage, que será a segunda tela mostrada ao usuário.
class SecondPage extends StatelessWidget {
  const SecondPage({super.key});

  @override
  Widget build(BuildContext context) {
    // Scaffold para estruturar a SecondPage.
    return Scaffold(
      appBar: AppBar(
        title: const Text('Second Page'),  // Define o título da AppBar.
      ),
      body: Center(
        child: ElevatedButton(
          // Ação executada ao pressionar o botão.
          onPressed: () {
            Navigator.pop(context);  // Volta para a HomePage ao clicar no botão.
          },
          child: const Text('Voltar para a Página Inicial'),  // Texto do botão.
        ),
      ),
    );
  }
}
