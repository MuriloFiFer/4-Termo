<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Disponibilidade extends Model
{
    use HasFactory;

    protected $fillable = [
        'data', 'horario', 'reservado', 'user_id'
    ];

    public function cliente()
    {
        return $this->belongsTo(User::class, 'user_id');
    }
}
