@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Detalhes da Consulta</h1>

    <div class="card">
        <div class="card-header">
            Consulta #{{ $consulta->id }}
        </div>
        <div class="card-body">
            <h5 class="card-title">Paciente: {{ $consulta->paciente ? $consulta->paciente->name : 'Não atribuído' }}</h5>
            <p class="card-text"><strong>Data:</strong> {{ \Carbon\Carbon::parse($consulta->data)->format('d/m/Y') }}</p>
            <p class="card-text"><strong>Hora:</strong> {{ \Carbon\Carbon::parse($consulta->hora)->format('H:i') }}</p>
            <p class="card-text"><strong>Especialidade:</strong> {{ $consulta->especialidade }}</p>
            <p class="card-text"><strong>Status:</strong> {{ ucfirst($consulta->status) }}</p>
            @if($consulta->observacoes)
                <p class="card-text"><strong>Observações:</strong> {{ $consulta->observacoes }}</p>
            @endif
        </div>
    </div>

    <a href="{{ route('consultas.index') }}" class="btn btn-secondary mt-3">Voltar</a>
</div>

@endsection
