<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta;
use Illuminate\Support\Facades\Auth;

class ConsultaController extends Controller
{
    public function index()
    {
        if (Auth::user()->isAdmin()) {
            $consultas = Consulta::all();
            return view('admin.dashboard', compact('consultas'));
        } else {
            $consultas = Consulta::where('status', '!=', 'concluida')->get();
            return view('consultas.index', compact('consultas'));
        }
    }

    public function create()
    {
        if (!Auth::user()->isAdmin()) {
            return view('consultas.create');
        } else {
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }

    public function store(Request $request)
    {
        if (!Auth::user()->isAdmin()) {
            $request->validate([
                'data' => 'required|date',
                'hora' => 'required|date_format:H:i',
                'especialidade' => 'required|string|max:255',
            ]);

            Consulta::create([
                'paciente_id' => Auth::id(),
                'data' => $request->data,
                'hora' => $request->hora,
                'especialidade' => $request->especialidade,
                'status' => 'disponivel',
            ]);

            return redirect()->route('cliente.dashboard')->with('success', 'Consulta agendada com sucesso');
        } else {
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }

    public function reservar($id)
    {
        if (!Auth::user()->isAdmin()) {
            $consulta = Consulta::where('id', $id)->where('status', 'disponivel')->firstOrFail();
            $consulta->update([
                'paciente_id' => Auth::id(),
                'status' => 'reservada',
            ]);

            return redirect()->route('cliente.dashboard')->with('success', 'Consulta reservada com sucesso');
        } else {
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }

    public function edit(Consulta $consulta)
    {
        if (Auth::user()->isAdmin()) {
            return view('consultas.edit', compact('consulta'));
        } else {
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    public function update(Request $request, Consulta $consulta)
    {
        if (Auth::user()->isAdmin()) {
            $request->validate([
                'data' => 'required|date',
                'hora' => 'required|date_format:H:i',
                'especialidade' => 'required|string|max:255',
            ]);

            $consulta->update($request->all());

            return redirect()->route('admin.dashboard')->with('success', 'Consulta atualizada com sucesso');
        } else {
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    public function destroy(Consulta $consulta)
    {
        if (Auth::user()->isAdmin()) {
            $consulta->delete();

            return redirect()->route('admin.dashboard')->with('success', 'Consulta deletada com sucesso');
        } else {
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    public function show(Consulta $consulta)
    {
        if (Auth::user()->isAdmin() || $consulta->paciente_id == Auth::id()) {
            return view('consultas.show', compact('consulta'));
        } else {
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    public function adminIndex()
    {
        if (Auth::user()->isAdmin()) {
            $consultas = Consulta::where('status', 'reservada')->get();
            return view('admin.dashboard', compact('consultas'));
        } else {
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    public function consultasReservadas()
    {
        if (!Auth::user()->isAdmin()) {
            $consultas = Consulta::where('paciente_id', Auth::id())->where('status', 'reservada')->get();
            return view('cliente.dashboard', compact('consultas'));
        } else {
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }
}
