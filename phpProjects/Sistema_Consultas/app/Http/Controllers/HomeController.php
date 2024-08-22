<?php

namespace App\Http\Controllers;

use App\Models\Consulta; // Adicione isso para acessar o modelo Consulta
use Illuminate\Http\Request;

class HomeController extends Controller
{
    /**
     * Exibe a página inicial.
     *
     * @return \Illuminate\View\View
     */
    public function index()
    {
        // Obtém todas as consultas
        $consultas = Consulta::all();

        // Passa a variável $consultas para a view
        return view('home', compact('consultas'));
    }
}
