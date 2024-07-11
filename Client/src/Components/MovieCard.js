import React from 'react';
import './MovieCard.css';

const MovieCard = ({ movie }) => {
  return (
    <div className="movie-card">
      <img src={movie.poster} alt={movie.title} />
      <div className="movie-details">
        <h3>{movie.title}</h3>
        <p>Duration: {movie.duration} min</p>
        <p>Average Stars: {movie.rating} ★</p>
        <p>Summary: {movie.summary}</p>
        <p>Year: {movie.year}</p>
      </div>
    </div>
  );
};

export default MovieCard;