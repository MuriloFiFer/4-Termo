@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Consultas Médicas</h1>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    {{-- Apenas o administrador pode criar novas consultas --}}
    @if(Auth::user()->isAdmin())
        <a class="btn btn-success mb-2" href="{{ route('consultas.create') }}">Agendar Nova Consulta</a>
    @endif

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
                
                {{-- Mostra o nome do paciente apenas se a consulta estiver reservada --}}
                <td>{{ $consulta->status === 'reservada' ? $consulta->paciente->name : 'Disponível' }}</td>
                
                <td>{{ \Carbon\Carbon::parse($consulta->data_hora)->format('d/m/Y') }}</td>
                <td>{{ \Carbon\Carbon::parse($consulta->data_hora)->format('H:i') }}</td>
                <td>{{ ucfirst($consulta->status) }}</td>
                <td>
                    {{-- Ações diferentes para administrador e cliente --}}
                    @if(Auth::user()->isAdmin())
                        <form action="{{ route('consultas.destroy', $consulta->id) }}" method="POST">
                            <a class="btn btn-primary" href="{{ route('consultas.edit', $consulta->id) }}">Editar</a>
                            
                            @csrf
                            @method('DELETE')
                            <button type="submit" class="btn btn-danger">Deletar</button>
                        </form>
                    @elseif($consulta->status === 'disponivel')
                        <a class="btn btn-success" href="{{ route('consultas.reservar', $consulta->id) }}">Reservar</a>
                    @else
                        <span class="text-muted">Reservada</span>
                    @endif
                </td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>

@endsection
