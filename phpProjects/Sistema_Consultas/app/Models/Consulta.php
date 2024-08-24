<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Carbon\Carbon;

class Consulta extends Model
{
    use HasFactory;

    // Definição dos campos que podem ser preenchidos em massa
    protected $fillable = [
        'data',
        'hora',
        'especialidade',
        'status',
        'paciente_id',
        'medico_id',
    ];

    // Relacionamento com o modelo Paciente
    public function paciente()
    {
        return $this->belongsTo(User::class, 'paciente_id');
    }

    public function medico()
    {
        return $this->belongsTo(User::class, 'medico_id');
    }

    public function getDataHoraAttribute()
    {
        // Verifica se data e hora não são nulos e combina os dois
        if ($this->data && $this->hora) {
            return \Carbon\Carbon::createFromFormat('Y-m-d H:i', $this->data . ' ' . $this->hora);
        }
        return null;
    }
}


