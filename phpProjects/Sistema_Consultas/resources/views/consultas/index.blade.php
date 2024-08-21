@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Consultas Médicas</h1>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    <a class="btn btn-success mb-2" href="{{ route('consultas.create') }}"> Agendar Nova Consulta</a>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>No</th>
                <th>Paciente</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Status</th>
                <th width="280px">Ação</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($consultas as $consulta)
            <tr>
                <td>{{ $loop->iteration }}</td>
                <td>{{ $consulta->paciente_nome }}</td>
                <td>{{ $consulta->data->format('d/m/Y') }}</td>
                <td>{{ $consulta->hora->format('H:i') }}</td>
                <td>{{ ucfirst($consulta->status) }}</td>
                <td>
                    <form action="{{ route('consultas.destroy', $consulta->id) }}" method="POST">
                        <a class="btn btn-primary" href="{{ route('consultas.edit', $consulta->id) }}">Editar</a>

                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Deletar</button>
                    </form>
                </td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>

@endsection
