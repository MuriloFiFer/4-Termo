@extends('layouts.app')

@section('content')
    <div class="container">
        <h1 class="my-4">Consultas Recentes</h1>

        @if ($consultas->isEmpty())
            <p>Não há consultas recentes.</p>
        @else
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Paciente</th>
                        <th>Data</th>
                        <th>Hora</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($consultas as $consulta)
                        <tr>
                            <td>{{ $consulta->id }}</td>
                            <td>{{ $consulta->paciente_nome }}</td>
                            <td>{{ $consulta->data->format('d/m/Y') }}</td>
                            <td>{{ $consulta->hora->format('H:i') }}</td>
                            <td>{{ ucfirst($consulta->status) }}</td>
                        </tr>
                    @endforeach
                </tbody>
            </table>
        @endif
    </div>
@endsection
