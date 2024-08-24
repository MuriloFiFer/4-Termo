@extends('layouts.app')

@section('content')
    <div class="container">
        <h1 class="my-4">Agendar Nova Consulta</h1>

        @if ($errors->any())
            <div class="alert alert-danger">
                <strong>Oops!</strong> Houve alguns problemas com sua entrada.<br><br>
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
                <label for="data">Data:</label>
                <input type="date" name="data" id="data" class="form-control" value="{{ old('data') }}" required>
                @error('data')
                    <div class="text-danger">{{ $message }}</div>
                @enderror
            </div>

            <div class="form-group mb-3">
                <label for="hora">Hora:</label>
                <input type="time" name="hora" id="hora" class="form-control" value="{{ old('hora') }}" required>
                @error('hora')
                    <div class="text-danger">{{ $message }}</div>
                @enderror
            </div>

            <div class="form-group mb-3">
                <label for="especialidade">Especialidade:</label>
                <input type="text" name="especialidade" id="especialidade" class="form-control" value="{{ old('especialidade') }}" required>
                @error('especialidade')
                    <div class="text-danger">{{ $message }}</div>
                @enderror
            </div>

            <button type="submit" class="btn btn-primary">Agendar</button>
        </form>
    </div>
@endsection
