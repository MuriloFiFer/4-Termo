@extends('layouts.app')

@section('content')

<div class="container">
    <h1 class="my-4">Agendar Nova Consulta</h1>

    @if ($errors->any())
        <div class="alert alert-danger">
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <form action="{{ route('consultas.store') }}" method="POST">
        @csrf

        <div class="form-group mb-3">
            <label for="data_hora">Data e Hora</label>
            <input type="datetime-local" name="data_hora" id="data_hora" class="form-control @error('data_hora') is-invalid @enderror" value="{{ old('data_hora') }}" required>
            @error('data_hora')
                <div class="invalid-feedback">{{ $message }}</div>
            @enderror
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</div>

@endsection
