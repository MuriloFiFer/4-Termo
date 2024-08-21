<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Consulta extends Model
{
    use HasFactory;
    
    protected $fillable = [
        'paciente_id',       // ID do paciente associado à consulta
        'medico_id',         // ID do médico responsável pela consulta
        'especialidade',     // Especialidade da consulta (ex: Cardiologia, Dermatologia)
        'data_hora',         // Data e hora agendada para a consulta
        'status',            // Status da consulta (ex: agendada, concluída, cancelada)
        'observacoes'        // Notas ou observações adicionais sobre a consulta
    ];
    
    // Relacionamento com o modelo Paciente
    public function paciente()
    {
        return $this->belongsTo(Paciente::class);
    }

    // Relacionamento com o modelo Médico
    public function medico()
    {
        return $this->belongsTo(Medico::class);
    }
}
