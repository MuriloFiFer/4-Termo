"use client";

import { useState } from 'react';
import Image from 'next/image';
import styles from '../page.module.css';
import Link from 'next/link';

export default function RegisterPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage(''); // Limpar a mensagem antes de submeter
    setError(null); // Limpar o erro antes de submeter
    
    try {
      const res = await fetch('/api/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
      });

      const data = await res.json();

      if (res.ok) {
        setMessage(data.message); // Mensagem de sucesso
      } else {
        setError(data.message); // Exibir mensagem de erro se a resposta não for bem-sucedida
      }
    } catch (err) {
      setError('Ocorreu um erro durante o cadastro. Tente novamente.'); // Capturar erros de rede ou outros
    }
  };

  return (
    <div className={styles.container}>
      <header className={styles.header}>
        <div className={styles.logoContainer}>
          <Image src="/logo.png" alt="Logo" width={100} height={50} />
          <p>Filmes Loctor</p>
        </div>
        <div className={styles.searchContainer}>
          <input type="text" placeholder="Pesquisar" />
          <button className={styles.searchButton}>Pesquisar</button>
        </div>
        <div className={styles.navLinks}>
          <Link href="/">Home</Link>
          <Link href="/categoria">Categoria</Link>
          <Link href="/catalogo">Catálogo</Link>
          <Link href="/login">Entrar</Link>
          <Link href="/register">Cadastrar</Link>
        </div>
      </header>

      <main className={styles.mainContent}>
        <h1>Cadastrar</h1>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="username">Nome de usuário:</label>
            <input
              type="text"
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <div>
            <label htmlFor="password">Senha:</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit">Cadastrar</button>
        </form>

        {/* Exibir mensagem de sucesso ou erro */}
        {message && <p style={{ color: 'green' }}>{message}</p>}
        {error && <p style={{ color: 'red' }}>{error}</p>}
      </main>

      <footer className={styles.footer}>
        <div className={styles.footerLogo}>
          <Image src="/logo.png" alt="Logo" width={100} height={50} />
        </div>
        <div className={styles.footerSlogan}>
          <p>Encontre, Alugue e Divirta-se – Filmes Incríveis ao Seu Alcance.</p>
        </div>
      </footer>
    </div>
  );
}
