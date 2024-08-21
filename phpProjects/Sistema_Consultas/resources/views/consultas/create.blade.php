@extends('layouts.app')

@section('content')
    <div class="container">
        <h1 class="my-4">Agendar Consulta</h1>

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
                <label for="paciente_nome">Nome do Paciente:</label>
                <input type="text" name="paciente_nome" id="paciente_nome" class="form-control" placeholder="Nome do Paciente" value="{{ old('paciente_nome') }}" required>
            </div>

            <div class="form-group mb-3">
                <label for="data">Data:</label>
                <input type="date" name="data" id="data" class="form-control" placeholder="Data" value="{{ old('data') }}" required>
            </div>

            <div class="form-group mb-3">
                <label for="hora">Hora:</label>
                <input type="time" name="hora" id="hora" class="form-control" placeholder="Hora" value="{{ old('hora') }}" required>
            </div>

            <div class="form-group mb-3">
                <label for="descricao">Descrição:</label>
                <textarea name="descricao" id="descricao" class="form-control" placeholder="Descrição" rows="3">{{ old('descricao') }}</textarea>
            </div>

            <div class="form-group mb-3">
                <label for="status">Status:</label>
                <select name="status" id="status" class="form-control" required>
                    <option value="pendente" {{ old('status') == 'pendente' ? 'selected' : '' }}>Pendente</option>
                    <option value="confirmado" {{ old('status') == 'confirmado' ? 'selected' : '' }}>Confirmado</option>
                    <option value="cancelado" {{ old('status') == 'cancelado' ? 'selected' : '' }}>Cancelado</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Agendar</button>
        </form>
    </div>
@endsection
