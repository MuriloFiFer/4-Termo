<?php

namespace App\Models;

use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;

class User extends Authenticatable
{
    use Notifiable;

    /**
     * Os atributos que são atribuíveis em massa.
     *
     * @var array
     */
    protected $fillable = [
        'name',
        'email',
        'password',
        'endereco',
        'telefone',
        'tipo_usuario',
    ];

    /**
     * Os atributos que devem ser ocultados para arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * Os atributos que devem ser lançados como datas.
     *
     * @var array
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
    ];

    /**
     * Verifica se o usuário é um administrador.
     */
    public function isAdmin()
    {
        return $this->tipo_usuario === 'administrador';
    }

    /**
     * Verifica se o usuário é um cliente.
     */
    public function isCliente()
    {
        return $this->tipo_usuario === 'cliente';
    }
}
