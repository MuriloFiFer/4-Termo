<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta;
use Illuminate\Support\Facades\Auth;

class DashboardController extends Controller
{
    /**
     * Método para exibir o dashboard geral.
     *
     * @param \Illuminate\Http\Request $request
     * @return \Illuminate\View\View
     */
    public function index(Request $request)
    {
        // Obtém o termo de busca a partir da requisição
        $search = $request->input('search');
        
        // Recupera as consultas com base no termo de busca
        $consultas = Consulta::when($search, function ($query, $search) {
            // Filtra as consultas pelo termo de busca nas colunas 'especialidade', 'data_hora' e 'status'
            return $query->where('especialidade', 'like', "%{$search}%")
                ->orWhere('data_hora', 'like', "%{$search}%")
                ->orWhere('status', 'like', "%{$search}%");
        })->get();

        // Retorna a view 'home' com as consultas filtradas
        return view('home', compact('consultas'));
    }

    /**
     * Método para exibir o dashboard do Administrador.
     *
     * @return \Illuminate\View\View
     */
    public function adminDashboard()
    {
        // Recupera todas as consultas com o status 'reservada'
        $consultas = Consulta::where('status', 'reservada')->get();

        // Retorna a view 'admin.dashboard' com as consultas reservadas
        return view('admin.dashboard', compact('consultas'));
    }

    /**
     * Método para exibir o dashboard do Cliente.
     *
     * @return \Illuminate\View\View
     */
    public function clienteDashboard()
    {
        // Recupera todas as consultas reservadas para o cliente autenticado
        $consultas = Consulta::where('paciente_id', Auth::id())->get();

        // Retorna a view 'cliente.dashboard' com as consultas do cliente
        return view('cliente.dashboard', compact('consultas'));
    }
}
