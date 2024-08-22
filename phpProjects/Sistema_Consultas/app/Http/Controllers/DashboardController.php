<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta;
use Illuminate\Support\Facades\Auth;

class DashboardController extends Controller
{
    /**
     * Método para o dashboard geral.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $consultas = Consulta::when($search, function ($query, $search) {
            return $query->where('especialidade', 'like', "%{$search}%")
                ->orWhere('data_hora', 'like', "%{$search}%")
                ->orWhere('status', 'like', "%{$search}%");
        })->get();

        return view('home', compact('consultas'));
    }

    /**
     * Método para o dashboard do Administrador.
     */
    public function adminDashboard()
    {
        // Recupera todas as consultas reservadas
        $consultas = Consulta::where('status', 'reservada')->get();
        return view('admin.dashboard', compact('consultas'));
    }

    /**
     * Método para o dashboard do Cliente.
     */
    public function clienteDashboard()
    {
        // Recupera todas as consultas reservadas para o cliente autenticado
        $consultas = Consulta::where('paciente_id', Auth::id())->get();
        return view('cliente.dashboard', compact('consultas'));
    }
}
