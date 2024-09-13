import axios from 'axios';
import { useRouter } from 'next/router';

const MovieDetail = ({ movie }) => {
  return (
    <div>
      <h1>{movie.title}</h1>
      <p>{movie.description}</p>
      <h3>Avaliações</h3>
      <ul>
        {movie.ratings.map((rating, idx) => (
          <li key={idx}>Nota: {rating}</li>
        ))}
      </ul>
    </div>
  );
};

export async function getServerSideProps({ params }) {
  const res = await axios.get(`http://localhost:3000/api/movies/${params.id}`);
  return { props: { movie: res.data.data } };
}

export default MovieDetail;
