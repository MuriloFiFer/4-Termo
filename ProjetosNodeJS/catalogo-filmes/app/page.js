import Image from 'next/image';
import styles from './page.module.css';

export default function HomePage() {
  return (
    <div className={styles.container}>
      {/* Header */}
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
          <a href="/categoria">Categoria</a>
          <a href="/catalogo">Catálogo</a>
          <a href="/login">Entrar</a>
          <a href="/register">Cadastrar</a>
        </div>
      </header>
      
      {/* Main Content */}
      <main className={styles.mainContent}>
        <h1>Filmes Adicionados</h1>
        <div className={styles.movieList}>
          <div className={styles.movieItem}>
            <Image
              src="/movie-placeholder.jpg"
              alt="Filme"
              width={100}
              height={150}
            />
            <div className={styles.movieDetails}>
              <h2>Nome do Filme</h2>
              <p>Descrição do filme...</p>
            
            </div>
          </div>
        </div>
      </main>

      {/* Footer */}
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
