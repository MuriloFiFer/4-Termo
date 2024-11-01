import 'package:flutter/material.dart';

class LoginScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Visitor Access Control')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pushNamed(context, '/scan');
          },
          child: Text('Iniciar Escaneamento de QR Code'),
        ),
      ),
    );
  }
}
