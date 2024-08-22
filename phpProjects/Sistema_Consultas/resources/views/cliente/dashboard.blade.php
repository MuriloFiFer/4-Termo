@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Dashboard do Cliente</h1>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    <h2>Minhas Consultas</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>No</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Especialidade</th>
                <th>Status</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($consultas as $consulta)
            <tr>
                <td>{{ $loop->iteration }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->data)->format('d/m/Y') }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->hora)->format('H:i') }}</td>
                <td>{{ $consulta->especialidade }}</td>
                <td>{{ ucfirst($consulta->status) }}</td>
                <td>
                    @if ($consulta->status == 'disponivel')
                        <a href="{{ route('consultas.reservar', $consulta->id) }}" class="btn btn-primary">Reservar</a>
                    @else
                        N/A
                    @endif
                </td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>

@endsection
