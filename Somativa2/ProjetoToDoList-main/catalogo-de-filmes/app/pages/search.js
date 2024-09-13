import axios from 'axios';
import { useState } from 'react';

const SearchPage = () => {
  const [query, setQuery] = useState('');
  const [results, setResults] = useState([]);

  const handleSearch = async () => {
    const res = await axios.get(`/api/movies?search=${query}`);
    setResults(res.data.data);
  };

  return (
    <div>
      <input
        type="text"
        value={query}
        onChange={e => setQuery(e.target.value)}
        placeholder="Buscar filmes..."
      />
      <button onClick={handleSearch}>Buscar</button>

      <ul>
        {results.map(movie => (
          <li key={movie._id}>{movie.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default SearchPage;
