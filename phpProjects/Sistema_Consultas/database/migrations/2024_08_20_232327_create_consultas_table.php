<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateConsultasTable extends Migration
{
    public function up()
    {
        Schema::create('consultas', function (Blueprint $table) {
            $table->id();
            $table->foreignId('paciente_id')->nullable()->constrained('users')->onDelete('set null');
            $table->foreignId('medico_id')->nullable()->constrained('users')->onDelete('set null');
            $table->date('data');
            $table->time('hora');
            $table->enum('status', ['disponivel', 'reservada', 'concluida'])->default('disponivel');
            $table->timestamps();
        });
    }

    public function down()
    {
        Schema::dropIfExists('consultas');
    }
}
