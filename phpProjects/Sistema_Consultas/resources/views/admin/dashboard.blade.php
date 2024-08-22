@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Dashboard do Administrador</h1>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

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
                <td>{{ $consulta->paciente->name }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->data_hora)->format('d/m/Y') }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->data_hora)->format('H:i') }}</td>
                <td>{{ $consulta->especialidade }}</td>
                <td>{{ ucfirst($consulta->status) }}</td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>

@endsection
