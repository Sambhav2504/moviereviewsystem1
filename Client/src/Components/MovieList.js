// client/src/components/MovieList.js
import React, { useState, useEffect } from 'react';
import MovieCard from './MovieCard';
import moviesData from '../moviesData';
import './MovieList.css';

const MovieList = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    
    setMovies(moviesData);
  }, []);

  return (
    <div className="movie-list">
      <div className="movie-container">
        {movies.map(movie => (
          <MovieCard key={movie.id} movie={movie} />
        ))}
      </div>
    </div>
  );
};

export default MovieList;