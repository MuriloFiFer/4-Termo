<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Consulta;
use Illuminate\Support\Facades\Auth;

class ConsultaController extends Controller
{
    /**
     * Exibe a lista de consultas.
     *
     * @return \Illuminate\View\View
     */
    public function index()
    {
        if (Auth::user()->isAdmin()) {
            // Se o usuário é um administrador, mostra todas as consultas.
            $consultas = Consulta::all();
            return view('admin.dashboard', compact('consultas'));
        } else {
            // Se o usuário não é administrador, mostra consultas que não estão concluídas.
            $consultas = Consulta::where('status', '!=', 'concluida')->get();
            return view('consultas.index', compact('consultas'));
        }
    }

    /**
     * Mostra o formulário para criar uma nova consulta.
     *
     * @return \Illuminate\View\View|\Illuminate\Http\RedirectResponse
     */
    public function create()
    {
        if (!Auth::user()->isAdmin()) {
            // Se o usuário não é administrador, exibe o formulário de criação.
            return view('consultas.create');
        } else {
            // Se o usuário é administrador, redireciona para o dashboard com uma mensagem de erro.
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }

    /**
     * Armazena uma nova consulta no banco de dados.
     *
     * @param \Illuminate\Http\Request $request
     * @return \Illuminate\Http\RedirectResponse
     */
    public function store(Request $request)
    {
        $request->validate([
            'data' => 'required|date',
            'hora' => 'required|date_format:H:i',
            'especialidade' => 'required|string|max:255',
        ]);

        // Criação da nova consulta com os dados fornecidos.
        $consulta = new Consulta([
            'data' => $request->get('data'),
            'hora' => $request->get('hora'),
            'especialidade' => $request->get('especialidade'),
            'status' => 'disponivel',
            'paciente_id' => Auth::id(), // Atribui o paciente atual como criador da consulta.
        ]);

        // Salvamento da consulta no banco de dados.
        $consulta->save();

        // Redireciona para o dashboard com uma mensagem de sucesso.
        return redirect()->route('admin.dashboard')->with('success', 'Consulta criada com sucesso!');
    }

    /**
     * Reserva uma consulta para o paciente atual.
     *
     * @param int $id
     * @return \Illuminate\Http\RedirectResponse
     */
    public function reservar($id)
    {
        if (!Auth::user()->isAdmin()) {
            $consulta = Consulta::where('id', $id)
                                ->where('status', 'disponivel')
                                ->firstOrFail();
            $consulta->update([
                'paciente_id' => Auth::id(),
                'status' => 'reservada',
            ]);

            // Redireciona para o dashboard do cliente com uma mensagem de sucesso.
            return redirect()->route('cliente.dashboard')->with('success', 'Consulta reservada com sucesso');
        } else {
            // Se o usuário é administrador, redireciona para o dashboard do administrador com uma mensagem de erro.
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }

    /**
     * Mostra o formulário para editar uma consulta existente.
     *
     * @param \App\Models\Consulta $consulta
     * @return \Illuminate\View\View|\Illuminate\Http\RedirectResponse
     */
    public function edit(Consulta $consulta)
    {
        if (Auth::user()->isAdmin()) {
            // Se o usuário é administrador, exibe o formulário de edição.
            return view('consultas.edit', compact('consulta'));
        } else {
            // Se o usuário não é administrador, redireciona para a home com uma mensagem de erro.
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    /**
     * Atualiza uma consulta existente no banco de dados.
     *
     * @param \Illuminate\Http\Request $request
     * @param \App\Models\Consulta $consulta
     * @return \Illuminate\Http\RedirectResponse
     */
    public function update(Request $request, Consulta $consulta)
    {
        if (Auth::user()->isAdmin()) {
            $request->validate([
                'data' => 'required|date',
                'hora' => 'required|date_format:H:i',
                'especialidade' => 'required|string|max:255',
            ]);

            // Atualiza a consulta com os novos dados fornecidos.
            $consulta->update($request->only(['data', 'hora', 'especialidade', 'status']));

            // Redireciona para o dashboard do administrador com uma mensagem de sucesso.
            return redirect()->route('admin.dashboard')->with('success', 'Consulta atualizada com sucesso');
        } else {
            // Se o usuário não é administrador, redireciona para a home com uma mensagem de erro.
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    /**
     * Remove uma consulta do banco de dados.
     *
     * @param \App\Models\Consulta $consulta
     * @return \Illuminate\Http\RedirectResponse
     */
    public function destroy(Consulta $consulta)
    {
        if (Auth::user()->isAdmin()) {
            $consulta->delete();

            // Redireciona para o dashboard do administrador com uma mensagem de sucesso.
            return redirect()->route('admin.dashboard')->with('success', 'Consulta deletada com sucesso');
        } else {
            // Se o usuário não é administrador, redireciona para a home com uma mensagem de erro.
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    /**
     * Exibe os detalhes de uma consulta específica.
     *
     * @param \App\Models\Consulta $consulta
     * @return \Illuminate\View\View|\Illuminate\Http\RedirectResponse
     */
    public function show(Consulta $consulta)
    {
        if (Auth::user()->isAdmin() || $consulta->paciente_id == Auth::id()) {
            // Se o usuário é administrador ou o paciente é o usuário atual, exibe os detalhes da consulta.
            return view('consultas.show', compact('consulta'));
        } else {
            // Se o usuário não tem permissão, redireciona para a home com uma mensagem de erro.
            return redirect()->route('home')->with('error', 'Acesso negado.');
        }
    }

    /**
     * Exibe as consultas reservadas pelo cliente atual.
     *
     * @return \Illuminate\View\View|\Illuminate\Http\RedirectResponse
     */
    public function consultasReservadas()
    {
        if (!Auth::user()->isAdmin()) {
            $consultas = Consulta::where('paciente_id', Auth::id())
                                 ->where('status', 'reservada')
                                 ->get();

            // Redireciona para o dashboard do cliente com as consultas reservadas.
            return view('cliente.dashboard', compact('consultas'));
        } else {
            // Se o usuário é administrador, redireciona para o dashboard do administrador com uma mensagem de erro.
            return redirect()->route('admin.dashboard')->with('error', 'Ação não permitida.');
        }
    }
}
