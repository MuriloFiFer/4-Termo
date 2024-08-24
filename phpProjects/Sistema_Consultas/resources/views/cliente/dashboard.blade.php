@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Dashboard do Cliente</h1>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    @if ($consultas->isEmpty())
        <p>Você não tem consultas agendadas.</p>
    @else
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Data e Hora</th>
                    <th>Especialidade</th>
                    <th>Paciente</th>
                    <th>Médico</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($consultas as $consulta)
                    <tr>
                        <td>
                            @if ($consulta->data && $consulta->hora)
                                {{ \Carbon\Carbon::parse($consulta->data . ' ' . $consulta->hora)->format('d/m/Y H:i') }}
                            @else
                                Data e Hora inválidas
                            @endif
                        </td>
                        <td>{{ $consulta->especialidade }}</td>
                        <td>
                            @if ($consulta->paciente)
                                {{ $consulta->paciente->name }}
                            @else
                                Paciente não disponível
                            @endif
                        </td>
                        <td>
                            @if ($consulta->medico)
                                {{ $consulta->medico->name }}
                            @else
                                Médico não disponível
                            @endif
                        </td>
                        <td>
                            @if ($consulta->status == 'disponivel')
                                <a href="{{ route('consultas.reservar', $consulta->id) }}" class="btn btn-primary">Confirmar</a>
                            @endif
                        </td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    @endif

    <a href="{{ route('consultas.create') }}" class="btn btn-primary">Adicionar Consulta</a>
  
</div>

@endsection
