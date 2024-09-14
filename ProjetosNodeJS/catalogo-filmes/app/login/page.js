import Image from 'next/image';
import styles from '../page.module.css'; // Ajuste o caminho conforme necessário
import Link from 'next/link'; // Importar Link do Next.js para navegação

export default function LoginPage() {
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
        <h1>Entrar</h1>
        <form>
          <div>
            <label htmlFor="email">Email:</label>
            <input type="email" id="email" placeholder="Digite seu email" required />
          </div>
          <div>
            <label htmlFor="password">Senha:</label>
            <input type="password" id="password" placeholder="Digite sua senha" required />
          </div>
          <button type="submit">Entrar</button>
        </form>
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
