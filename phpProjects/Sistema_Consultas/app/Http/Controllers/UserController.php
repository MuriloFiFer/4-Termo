<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    // Exibir o formulário de login
    public function showLoginForm()
    {
        return view('usuarios.login');
    }

    // Processar o login do usuário
    public function login(Request $request)
    {
        $credentials = $request->validate([
            'email' => ['required', 'email'],
            'password' => ['required'],
        ]);

        if (Auth::attempt($credentials)) {
            $request->session()->regenerate();

            // Redireciona para diferentes dashboards dependendo do tipo de usuário
            if (Auth::user()->isAdmin()) {
                return redirect()->intended('/admin/dashboard');
            } elseif (Auth::user()->isCliente()) {
                return redirect()->intended('/cliente/dashboard');
            }

            return redirect()->intended('/dashboard'); // Default redirection
        }

        return back()->withErrors([
            'email' => 'As credenciais não correspondem aos nossos registros.',
        ])->onlyInput('email');
    }

    // Exibir o formulário de registro
    public function showRegistroForm()
    {
        return view('usuarios.registro');
    }

    // Processar o registro de um novo usuário
    public function registro(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:8|confirmed',
            'endereco' => 'nullable|string|max:255',
            'telefone' => 'nullable|string|max:20',
            'tipo_usuario' => 'required|string|in:administrador,cliente',
        ]);

        User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
            'endereco' => $request->endereco,
            'telefone' => $request->telefone,
            'tipo_usuario' => $request->tipo_usuario,
        ]);

        return redirect('/dashboard'); // Redireciona para o dashboard ou página inicial apropriada
    }

    // Realizar o logout do usuário
    public function logout(Request $request)
    {
        Auth::logout();

        $request->session()->invalidate();
        $request->session()->regenerateToken();

        return redirect('/');
    }
}
