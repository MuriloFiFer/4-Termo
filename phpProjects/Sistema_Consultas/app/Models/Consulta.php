<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Consulta extends Model
{
    use HasFactory;

    // Definição dos campos que podem ser preenchidos em massa
    protected $fillable = [
        'paciente_id',
        'medico_id',
        'especialidade',
        'data_hora',
        'status',
        'observacoes'
    ];

    // Relacionamento com o modelo Paciente
    public function paciente()
    {
        return $this->belongsTo(User::class, 'paciente_id');
    }

    // Relacionamento com o modelo Médico
    public function medico()
    {
        return $this->belongsTo(User::class, 'medico_id');
    }

    // Opcional: Escopo para consultas disponíveis
    public function scopeDisponivel($query)
    {
        return $query->where('status', 'disponivel');
    }

    // Opcional: Escopo para consultas reservadas
    public function scopeReservada($query)
    {
        return $query->where('status', 'reservada');
    }
}
