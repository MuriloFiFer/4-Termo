@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Editar Consulta</h1>

    @if ($errors->any())
        <div class="alert alert-danger">
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <form action="{{ route('consultas.update', $consulta->id) }}" method="POST">
        @csrf
        @method('PUT')

        <div class="form-group mb-3">
            <label for="data">Data:</label>
            <input type="date" name="data" id="data" class="form-control" value="{{ old('data', $consulta->data) }}" required>
        </div>

        <div class="form-group mb-3">
            <label for="hora">Hora:</label>
            <input type="time" name="hora" id="hora" class="form-control" value="{{ old('hora', $consulta->hora) }}" required>
        </div>

        <div class="form-group mb-3">
            <label for="especialidade">Especialidade:</label>
            <input type="text" name="especialidade" id="especialidade" class="form-control" value="{{ old('especialidade', $consulta->especialidade) }}" required>
        </div>

        <button type="submit" class="btn btn-primary">Atualizar</button>
    </form>
</div>

@endsection
