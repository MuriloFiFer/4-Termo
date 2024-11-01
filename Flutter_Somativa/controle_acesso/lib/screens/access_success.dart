import 'package:flutter/material.dart';

class AccessSuccess extends StatelessWidget {
  final String visitorName;
  AccessSuccess({required this.visitorName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Acesso Permitido')),
      body: Center(
        child: Text(
          'Bem-vindo, $visitorName',
          style: TextStyle(fontSize: 24),
        ),
      ),
    );
  }
}
