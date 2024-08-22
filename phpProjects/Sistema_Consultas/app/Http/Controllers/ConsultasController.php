<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta;
use Illuminate\Support\Facades\Auth;

class ConsultaController extends Controller
{
    // Lista todas as consultas disponíveis e reservadas
    public function index()
    {
        $consultas = Consulta::where('status', '!=', 'concluida')->get();
        return view('consultas.index', compact('consultas'));
    }

    // Abre o formulário de cadastro de consulta para o administrador
    public function create()
    {
        return view('consultas.create');
    }

    // Envia o formulário de cadastro de consulta
    public function store(Request $request)
    {
        $request->validate([
            'data_hora' => 'required|date_format:Y-m-d H:i:s',
            'medico_id' => 'required|exists:users,id',
            'especialidade' => 'required|string|max:255',
        ]);

        Consulta::create([
            'medico_id' => $request->medico_id,
            'data_hora' => $request->data_hora,
            'especialidade' => $request->especialidade,
            'status' => 'disponivel',
        ]);

        return redirect()->route('consultas.index')->with('success', 'Consulta criada com sucesso');
    }

    // Reserva uma consulta pelo cliente
    public function reservar($id)
    {
        $consulta = Consulta::where('id', $id)->where('status', 'disponivel')->firstOrFail();
        $consulta->update([
            'paciente_id' => Auth::id(),
            'status' => 'reservada',
        ]);

        return redirect()->route('consultas.index')->with('success', 'Consulta reservada com sucesso');
    }

    // Mostra o formulário para editar a consulta
    public function edit(Consulta $consulta)
    {
        return view('consultas.edit', compact('consulta'));
    }

    // Atualiza a consulta
    public function update(Request $request, Consulta $consulta)
    {
        $request->validate([
            'data_hora' => 'required|date_format:Y-m-d H:i:s',
            'medico_id' => 'required|exists:users,id',
            'especialidade' => 'required|string|max:255',
        ]);

        $consulta->update($request->all());

        return redirect()->route('consultas.index')->with('success', 'Consulta atualizada com sucesso');
    }

    // Remove a consulta
    public function destroy(Consulta $consulta)
    {
        $consulta->delete();

        return redirect()->route('consultas.index')->with('success', 'Consulta deletada com sucesso');
    }

    // Mostra uma consulta específica
    public function show(Consulta $consulta)
    {
        return view('consultas.show', compact('consulta'));
    }

    // Lista todas as consultas reservadas para o administrador
    public function adminIndex()
    {
        $consultas = Consulta::where('status', 'reservada')->get();
        return view('consultas.admin-index', compact('consultas'));
    }

    // Lista todas as consultas reservadas pelo cliente
    public function clienteIndex()
    {
        $consultas = Consulta::where('paciente_id', Auth::id())->get();
        return view('consultas.cliente-index', compact('consultas'));
    }
}
