import axios from 'axios';
import { useEffect, useState } from 'react';

const HomePage = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    axios.get('/api/movies')
      .then(response => setMovies(response.data.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h1>Filmes Populares</h1>
      <ul>
        {movies.map(movie => (
          <li key={movie._id}>{movie.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default HomePage;
