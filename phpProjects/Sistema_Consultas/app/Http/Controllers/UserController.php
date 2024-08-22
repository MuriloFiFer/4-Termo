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
            'tipo_usuario' => 'nullable|string|in:administrador,cliente', // Nullable porque será cliente por padrão
        ]);

        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
            'tipo_usuario' => $request->tipo_usuario ?? 'cliente', // Define padrão para cliente
        ]);

        Auth::login($user); // Faz o login automático após o registro

        // Redireciona com base no tipo de usuário
        if ($user->isAdmin()) {
            return redirect('/admin/dashboard');
        } elseif ($user->isCliente()) {
            return redirect('/cliente/dashboard');
        }

        return redirect('/dashboard'); // Redirecionamento padrão
    }

    // Realizar o logout do usuário
    public function logout(Request $request)
    {
        Auth::logout();

        $request->session()->invalidate();
        $request->session()->regenerateToken(); // Corrigido

        return redirect('/');
    }
}
