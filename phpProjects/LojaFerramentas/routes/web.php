<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;use App\Http\Controllers\ProdutoController;
use SebastianBergmann\CodeCoverage\Report\Html\Dashboard;

Route::get('/', function () {
    return view('home');
});

//rota registro 
//rota para exibir o formulario de registro
Route::get('/registro',[UserController::class, 'showRegistroForm'])->
name('usuarios.registro');

//rota para processar o registro
Route::post('/registro',[UserController::class, 'registro'])->
name('usuarios.registro');


//rotas login

//rota para exibir o formulario de registro
Route::get('/login',[UserController::class, 'showLoginForm'])->
name('usuarios.login');

//rota para processar o login
Route::post('/login',[UserController::class, 'login'])->
name('usuarios.login');


//rota para opgina interna

Route::get('/dashboard', function () {
    return view('usuarios.dashboard');
})->middleware('auth')->name('usuarios.dashboard');


//rota do logout
Route::post('/logout', [UserController::class, 'logout']);

//rota para produtos
Route::resource('produtos', ProdutoController::class)->middleware('auth');

