import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Layouts',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Layouts (Row, Column, Stack)'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.star),
                SizedBox(width: 10),
                Icon(Icons.favorite),
              ],
            ),
            const SizedBox(height: 20),
            const Text('Este é um exemplo de Row.'),
            const SizedBox(height: 20),
            Stack(
              alignment: Alignment.center,
              children: <Widget>[
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.blue,
                ),
                const Text('Texto sobreposto', style: TextStyle(color: Colors.white)),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
