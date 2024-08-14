@if (Auth::check())
<div>
    <h3>Olá, {{Auth::user()->name}}</h3>
</div>
    <form action="/logout" method="post">
        @csrf
        <button type="submit" type="submit">Logout</button>
    </form>
@else
    <div>
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/register">Registro</a></li>
        </ul>
    </div>
@endif