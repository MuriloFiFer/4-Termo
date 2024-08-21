<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta; // Altere para o modelo de Consulta

class DashboardController extends Controller
{
    public function index(Request $request)
    {
        $search = $request->input('search');
        $consultas = Consulta::when($search, function ($query, $search) {
            return $query->where('paciente_nome', 'like', "%{$search}%")
                ->orWhere('data', 'like', "%{$search}%")
                ->orWhere('hora', 'like', "%{$search}%")
                ->orWhere('status', 'like', "%{$search}%");
        })->get();

        return view('usuarios.dashboard', compact('consultas'));
    }
}
