<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta;
use Illuminate\Support\Facades\Auth;

class ConsultaController extends Controller
{
    /**
     * Display a listing of the consultations.
     */
    public function index()
    {
        $consultas = Consulta::where('status', '!=', 'concluida')->get();
        return view('consultas.index', compact('consultas'));
    }

    /**
     * Show the form for creating a new consultation.
     */
    public function create()
    {
        return view('consultas.create');
    }

    /**
     * Store a newly created consultation in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'data' => 'required|date',
            'hora' => 'required|date_format:H:i',
            'especialidade' => 'required|string|max:255',
        ]);

        Consulta::create([
            'medico_id' => Auth::id(), // Defina como o médico é atribuído
            'data' => $request->data,
            'hora' => $request->hora,
            'especialidade' => $request->especialidade,
            'status' => 'disponivel',
        ]);

        return redirect()->route('consultas.index')->with('success', 'Consulta criada com sucesso');
    }

    /**
     * Reserve a consultation by the client.
     */
    public function reservar($id)
    {
        $consulta = Consulta::where('id', $id)
                            ->where('status', 'disponivel')
                            ->firstOrFail();

        // Confirma que o usuário é um cliente e não pode reservar a mesma consulta mais de uma vez
        if (Auth::user()->tipo_usuario !== 'cliente') {
            return redirect()->route('consultas.index')->with('error', 'Você não tem permissão para reservar consultas.');
        }

        $consulta->update([
            'paciente_id' => Auth::id(),
            'status' => 'reservada',
        ]);

        return redirect()->route('consultas.index')->with('success', 'Consulta reservada com sucesso');
    }

    /**
     * Show the form for editing the specified consultation.
     */
    public function edit(Consulta $consulta)
    {
        return view('consultas.edit', compact('consulta'));
    }

    /**
     * Update the specified consultation in storage.
     */
    public function update(Request $request, Consulta $consulta)
    {
        $request->validate([
            'data' => 'required|date',
            'hora' => 'required|date_format:H:i',
            'especialidade' => 'required|string|max:255',
        ]);

        $consulta->update($request->all());

        return redirect()->route('consultas.index')->with('success', 'Consulta atualizada com sucesso');
    }

    /**
     * Remove the specified consultation from storage.
     */
    public function destroy(Consulta $consulta)
    {
        $consulta->delete();

        return redirect()->route('consultas.index')->with('success', 'Consulta deletada com sucesso');
    }

    /**
     * Display the specified consultation.
     */
    public function show(Consulta $consulta)
    {
        return view('consultas.show', compact('consulta'));
    }

    /**
     * Display the list of reserved consultations for the admin.
     */
    public function adminIndex()
    {
        $consultas = Consulta::where('status', 'reservada')->get();
        return view('admin.dashboard', compact('consultas'));
    }

    /**
     * Display the list of reserved consultations for the client.
     */
    public function consultasReservadas()
    {
        $consultas = Consulta::where('paciente_id', Auth::id())
                             ->where('status', 'reservada')
                             ->get();
        return view('cliente.dashboard', compact('consultas'));
    }
}
