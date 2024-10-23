import 'package:flutter/material.dart';

// Função principal, ponto de entrada da aplicação Flutter.
void main() {
  runApp(const MyApp());
}

// A classe MyApp é um widget sem estado (Stateless), que define a estrutura inicial do aplicativo.
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // O método build descreve como o widget deve ser exibido na tela.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Layouts', // Título do aplicativo.
      theme: ThemeData(
        // Define o esquema de cores com base em uma cor de semente (deepPurple).
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true, // Usa a versão mais recente dos componentes de Material Design.
      ),
      home: const MyHomePage(), // Define o widget MyHomePage como a página inicial do app.
    );
  }
}

// A classe MyHomePage também é um widget sem estado (Stateless), representando a tela principal.
class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  // O método build descreve a interface da página principal do aplicativo.
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Layouts (Row, Column, Stack)'), // Título da AppBar.
      ),
      // O corpo da página é um Center que centraliza os widgets filhos.
      body: Center(
        child: Column(
          // Centraliza o conteúdo verticalmente no centro da coluna.
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // O Row alinha seus filhos horizontalmente.
            Row(
              // Centraliza os widgets filhos dentro da Row.
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.star), // Ícone de estrela.
                SizedBox(width: 10), // Espaçamento horizontal entre os ícones.
                Icon(Icons.favorite), // Ícone de coração.
              ],
            ),
            const SizedBox(height: 20), // Espaçamento vertical entre o Row e o texto.
            const Text('Este é um exemplo de Row.'), // Texto abaixo da Row.
            const SizedBox(height: 20), // Espaçamento vertical entre o texto e o Stack.
            // O Stack permite sobrepor widgets uns sobre os outros.
            Stack(
              alignment: Alignment.center, // Alinha os widgets filhos ao centro do Stack.
              children: <Widget>[
                // Um Container azul de 100x100 pixels.
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.blue,
                ),
                // Texto sobreposto ao Container.
                const Text(
                  'Texto sobreposto', 
                  style: TextStyle(color: Colors.white), // Cor do texto branca para contraste.
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
