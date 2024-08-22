@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Consultas</h1>

    @if ($consultas->isEmpty())
        <p>Não há consultas disponíveis.</p>
    @else
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Data e Hora</th>
                    <th>Especialidade</th>
                    <th>Paciente</th>
                    <th>Médico</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($consultas as $consulta)
                    <tr>
                        <td>{{ $consulta->data_hora->format('d/m/Y H:i') }}</td>
                        <td>{{ $consulta->especialidade }}</td>
                        <td>{{ $consulta->paciente->name }}</td>
                        <td>{{ $consulta->medico->name }}</td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    @endif
</div>
@endsection
