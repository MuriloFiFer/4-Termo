@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Consultas Reservadas</h1>
    @foreach($consultas as $consulta)
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">{{ $consulta->data_hora }} - {{ $consulta->especialidade }}</h5>
                <p>Reservado por: {{ $consulta->paciente->name }}</p>
                <p>Médico: {{ $consulta->medico->name }}</p>
            </div>
        </div>
    @endforeach
</div>
@endsection
