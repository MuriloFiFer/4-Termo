@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Dashboard do Administrador</h1>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    <a class="btn btn-success mb-2" href="{{ route('consultas.create') }}">Agendar Nova Consulta</a>

    <h2>Consultas Reservadas</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>No</th>
                <th>Paciente</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Especialidade</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($consultas as $consulta)
            <tr>
                <td>{{ $loop->iteration }}</td>
                <td>{{ $consulta->paciente ? $consulta->paciente->name : 'Não atribuído' }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->data)->format('d/m/Y') }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->hora)->format('H:i') }}</td>
                <td>{{ $consulta->especialidade }}</td>
                <td>{{ ucfirst($consulta->status) }}</td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>

@endsection
