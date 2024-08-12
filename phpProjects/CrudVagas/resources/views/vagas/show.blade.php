@extends ('layouts.master')

@section('content')

<div class="container">
    <h1 class="my-4">Detalhes da Vaga</h1>

    <div class="form-group">
        <strong>Título:</strong>
        {{ $produto->titulo }}
    </div>

    <div class="form-group">
        <strong>Setor</strong>
        {{ $produto->setor}}
    </div>

    <div class="form-group">
        <strong>Descrição:</strong>
        {{ $produto->descricao}}
    </div>

    <div class="form-group">
        <strong>Remuneração:</strong>
        {{ $produto->remuneracao}}
    </div>

    <div class="form-group">
        <strong>Empresa:</strong>
        {{ $produto->empresa}}
    </div>

    <a class="btn btn-primary" href="{{ route('produtos.index') }}">Voltar</a>
</div>
