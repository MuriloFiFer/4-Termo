<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Disponibilidade;
use Illuminate\Support\Facades\Auth;

class DisponibilidadeController extends Controller
{
    /**
     * Método para exibir o formulário de criação de disponibilidade.
     *
     * @return \Illuminate\View\View
     */
    public function create()
    {
        // Retorna a view 'disponibilidades.create' com o formulário para criar uma nova disponibilidade
        return view('disponibilidades.create');
    }

    /**
     * Método para armazenar uma nova disponibilidade no banco de dados.
     *
     * @param \Illuminate\Http\Request $request
     * @return \Illuminate\Http\RedirectResponse
     */
    public function store(Request $request)
    {
        // Valida os dados recebidos no formulário
        $request->validate([
            'data' => 'required|date', // Data obrigatória e no formato de data
            'horario' => 'required',    // Horário obrigatório
        ]);

        // Cria uma nova disponibilidade com os dados fornecidos
        Disponibilidade::create([
            'data' => $request->data,    // A data da disponibilidade
            'horario' => $request->horario, // O horário da disponibilidade
        ]);

        // Redireciona para o dashboard com uma mensagem de sucesso
        return redirect()->route('dashboard')->with('success', 'Disponibilidade criada com sucesso.');
    }

    /**
     * Método para reservar uma disponibilidade.
     *
     * @param int $id
     * @return \Illuminate\Http\RedirectResponse
     */
    public function reservar($id)
    {
        // Encontra a disponibilidade pelo ID ou retorna um erro 404 se não encontrada
        $disponibilidade = Disponibilidade::findOrFail($id);

        // Verifica se a disponibilidade já está reservada
        if ($disponibilidade->reservado) {
            // Retorna para a página anterior com uma mensagem de erro
            return back()->withErrors('Essa data já foi reservada.');
        }

        // Atualiza a disponibilidade para marcada como reservada e atribui o usuário autenticado como o responsável
        $disponibilidade->update([
            'reservado' => true,       // Marca a disponibilidade como reservada
            'user_id' => Auth::id(),   // Atribui o ID do usuário autenticado
        ]);

        // Redireciona para o dashboard com uma mensagem de sucesso
        return redirect()->route('dashboard')->with('success', 'Consulta reservada com sucesso.');
    }

    /**
     * Método para listar todas as disponibilidades não reservadas.
     *
     * @return \Illuminate\View\View
     */
    public function listarDisponibilidades()
    {
        // Recupera todas as disponibilidades que não estão reservadas
        $disponibilidades = Disponibilidade::where('reservado', false)->get();

        // Retorna a view 'disponibilidades.index' com as disponibilidades não reservadas
        return view('disponibilidades.index', compact('disponibilidades'));
    }

    /**
     * Método para listar todas as reservas.
     *
     * @return \Illuminate\View\View
     */
    public function listarReservas()
    {
        // Recupera todas as disponibilidades reservadas e carrega as informações do cliente associado
        $reservas = Disponibilidade::where('reservado', true)->with('cliente')->get();

        // Retorna a view 'disponibilidades.reservas' com as reservas
        return view('disponibilidades.reservas', compact('reservas'));
    }
}
