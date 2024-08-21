<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Models\Consulta;

class HomeController extends Controller
{
    public function index()
    {
        // Pegue as 5 consultas mais recentes, por exemplo
        $consultas = Consulta::latest()->take(5)->get();

        // Se precisar de mais dados ou informações adicionais, adicione aqui
        // Exemplo: $usuarios = User::all();

        return view('home', compact('consultas'));
    }
}
