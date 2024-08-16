<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\ProdutoController;
use App\Http\Middleware\ProdutosMiddleware;
use App\Http\Controllers\HomeController;

//Pagina inicial com carroessel de produtos
Route::get('/', [HomeController::class, 'index'])->name('home');

//rota para exibir o formulario de registro
Route::get('/registro',[UserController::class, 'showRegistroForm'])->
name('usuarios.registro');

//rota para processar o registro
Route::post('/registro',[UserController::class, 'registro'])->
name('usuarios.registro');

//rota para exibir o formulario de registro
Route::get('/login',[UserController::class, 'showLoginForm'])->
name('usuarios.login');

//rota para processar o login
Route::post('/login',[UserController::class, 'login'])->
name('usuarios.login');

//rota para a pagina interna

Route::get('/dashboard', function () {
    return view('usuarios.dashboard');
})->middleware('auth')->name('usuarios.dashboard');

//rota do logout
Route::post('/logout', [UserController::class, 'logout']);

//rota para Produtos
Route::resource('produtos', ProdutoController::class)->
middleware(ProdutosMiddleware::class);

