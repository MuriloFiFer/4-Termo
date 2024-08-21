<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\ConsultaController;
use App\Http\Middleware\ConsultasMiddleware;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\DashboardController;

// Página inicial com consultas
Route::get('/', [HomeController::class, 'index'])->name('home');

// Rota para exibir o formulário de registro
Route::get('/registro', [UserController::class, 'showRegistroForm'])->name('register');

// Rota para processar o registro
Route::post('/registro', [UserController::class, 'registro'])->name('register');

// Rota para exibir o formulário de login
Route::get('/login', [UserController::class, 'showLoginForm'])->name('login');

// Rota para processar o login
Route::post('/login', [UserController::class, 'login'])->name('login');

// Rota para a página interna (dashboard)
Route::get('/dashboard', [DashboardController::class, 'index'])->middleware('auth')->name('dashboard');

// Rota do logout
Route::post('/logout', [UserController::class, 'logout'])->name('logout');

// Rota para Consultas
Route::resource('consultas', ConsultaController::class)
    ->middleware(ConsultasMiddleware::class)->except('show');

// Visualização de uma consulta específica
Route::get('consultas/{consulta}', [ConsultaController::class, 'show'])->middleware('auth')->name('consultas.show');
