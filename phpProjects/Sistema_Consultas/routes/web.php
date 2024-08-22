<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\ConsultaController;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\DashboardController;

// Página inicial com consultas
Route::get('/', [HomeController::class, 'index'])->name('home');

// Rota para exibir o formulário de registro
Route::get('/register', [UserController::class, 'showRegistroForm'])->name('register.form');

// Rota para processar o registro
Route::post('/register', [UserController::class, 'registro'])->name('register');

// Rota para exibir o formulário de login
Route::get('/login', [UserController::class, 'showLoginForm'])->name('login');

// Rota para processar o login
Route::post('/login', [UserController::class, 'login'])->name('login');

// Rota para a página interna (dashboard) - Redirecionamento genérico para o dashboard
Route::get('/dashboard', [DashboardController::class, 'index'])->middleware('auth')->name('dashboard');

// Rota para o dashboard do administrador
Route::get('/admin/dashboard', [DashboardController::class, 'adminDashboard'])->middleware('auth')->name('admin.dashboard');

// Rota para o dashboard do cliente
Route::get('/cliente/dashboard', [DashboardController::class, 'clienteDashboard'])->middleware('auth')->name('cliente.dashboard');

// Rota do logout
Route::post('/logout', [UserController::class, 'logout'])->name('logout');

// Rotas para Consultas
Route::resource('consultas', ConsultaController::class)->middleware('auth')->except('show');

// Reservar uma consulta
Route::get('consultas/{id}/reservar', [ConsultaController::class, 'reservar'])->middleware('auth')->name('consultas.reservar');

// Visualizar uma consulta específica
Route::get('consultas/{consulta}', [ConsultaController::class, 'show'])->middleware('auth')->name('consultas.show');

// Consultas reservadas para o administrador
Route::get('/admin/consultas-reservadas', [ConsultaController::class, 'adminIndex'])->middleware('auth')->name('consultas.adminIndex');

// Consultas reservadas para o cliente
Route::get('/cliente/consultas-reservadas', [ConsultaController::class, 'consultasReservadas'])->middleware('auth')->name('consultas.reservadas');
