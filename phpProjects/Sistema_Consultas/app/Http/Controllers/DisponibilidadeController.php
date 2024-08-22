<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Disponibilidade;
use Illuminate\Support\Facades\Auth;

class DisponibilidadeController extends Controller
{
    public function create()
    {
        return view('disponibilidades.create');
    }

    public function store(Request $request)
    {
        $request->validate([
            'data' => 'required|date',
            'horario' => 'required',
        ]);

        Disponibilidade::create([
            'data' => $request->data,
            'horario' => $request->horario,
        ]);

        return redirect()->route('dashboard')->with('success', 'Disponibilidade criada com sucesso.');
    }

    public function reservar($id)
    {
        $disponibilidade = Disponibilidade::findOrFail($id);
        if ($disponibilidade->reservado) {
            return back()->withErrors('Essa data já foi reservada.');
        }

        $disponibilidade->update([
            'reservado' => true,
            'user_id' => Auth::id(),
        ]);

        return redirect()->route('dashboard')->with('success', 'Consulta reservada com sucesso.');
    }

    public function listarDisponibilidades()
    {
        $disponibilidades = Disponibilidade::where('reservado', false)->get();
        return view('disponibilidades.index', compact('disponibilidades'));
    }

    public function listarReservas()
    {
        $reservas = Disponibilidade::where('reservado', true)->with('cliente')->get();
        return view('disponibilidades.reservas', compact('reservas'));
    }
}
