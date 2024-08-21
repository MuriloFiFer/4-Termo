@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <!-- Supondo que você tenha uma imagem para a consulta -->
                <img src="/assets/img/consulta.png" class="img-fluid" alt="Detalhes da Consulta">
            </div>
            <div class="col-md-6">
                <h2>Consulta com {{ $consulta->paciente_nome }}</h2>
                <p>Data: {{ $consulta->data }}</p>
                <p>Hora: {{ $consulta->hora }}</p>
                <p>Status: {{ $consulta->status }}</p>
                <p>Descrição: {{ $consulta->descricao }}</p>

                <!-- Supondo que haja uma ação disponível para confirmar ou cancelar a consulta -->
                <form method="POST" action="{{ route('consultas.update', $consulta->id) }}">
                    @csrf
                    @method('PUT')

                    <div class="form-group">
                        <label for="status">Atualizar Status</label>
                        <select name="status" class="form-control">
                            <option value="agendada" {{ $consulta->status == 'agendada' ? 'selected' : '' }}>Agendada</option>
                            <option value="confirmada" {{ $consulta->status == 'confirmada' ? 'selected' : '' }}>Confirmada</option>
                            <option value="cancelada" {{ $consulta->status == 'cancelada' ? 'selected' : '' }}>Cancelada</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary mt-3">Atualizar Status</button>
                </form>
            </div>
        </div>
    </div>
@endsection
