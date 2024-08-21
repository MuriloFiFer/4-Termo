@extends('layouts.app')

@section('content')
    <h1>Dashboard de Consultas</h1>

    <form method="GET" action="{{ route('dashboard') }}">
        <input type="text" name="search" placeholder="Pesquisar consultas..." value="{{ request('search') }}">
        <button type="submit">Pesquisar</button>
    </form>

    <div class="row">
        @foreach ($consultas as $consulta)
            <div class="col-md-4">
                <div class="card">
                    <img src="/assets/img/consulta.png" class="card-img-top" alt="Consulta">
                    <div class="card-body">
                        <h5 class="card-title">Consulta com {{ $consulta->paciente_nome }}</h5>
                        <p class="card-text">Data: {{ $consulta->data->format('d/m/Y') }}</p>
                        <p class="card-text">Hora: {{ $consulta->hora->format('H:i') }}</p>
                        <p class="card-text">Status: {{ ucfirst($consulta->status) }}</p>
                        <a href="{{ route('consultas.show', $consulta->id) }}" class="btn btn-primary">Ver Detalhes</a>
                    </div>
                </div>
            </div>
        @endforeach
    </div>
@endsection
