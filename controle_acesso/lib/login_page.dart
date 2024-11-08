import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  String _errorMessage = '';

  // Método para autenticar o usuário
  Future<void> _login() async {
    try {
      // Tenta fazer o login com email e senha
      await FirebaseAuth.instance.signInWithEmailAndPassword(
        email: _emailController.text,
        password: _passwordController.text,
      );
      // Caso o login seja bem-sucedido, você pode redirecionar para a próxima página
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Login bem-sucedido!")),
      );
    } on FirebaseAuthException catch (e) {
      // Exibe mensagem de erro caso o login falhe
      setState(() {
        _errorMessage = e.message ?? 'Erro desconhecido';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Login'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _emailController,
              decoration: InputDecoration(
                labelText: 'Email',
                hintText: 'Digite seu email',
                errorText: _errorMessage.isNotEmpty ? _errorMessage : null,
              ),
            ),
            SizedBox(height: 16),
            TextField(
              controller: _passwordController,
              obscureText: true,
              decoration: InputDecoration(
                labelText: 'Senha',
                hintText: 'Digite sua senha',
                errorText: _errorMessage.isNotEmpty ? _errorMessage : null,
              ),
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: _login,
              child: Text('Entrar'),
            ),
            SizedBox(height: 16),
            TextButton(
              onPressed: () {
                // Redireciona para a página de cadastro, caso queira implementar
              },
              child: Text('Criar conta'),
            ),
          ],
        ),
      ),
    );
  }
}
