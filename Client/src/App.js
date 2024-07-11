import React, { useState } from 'react';
import './App.css';
import movies from './moviesData';

function App() {
  const [selectedMovie, setSelectedMovie] = useState(null);

  const handleCardClick = (movie) => {
    setSelectedMovie(movie);
  };

  const handleClosePopup = () => {
    setSelectedMovie(null);
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Movie Review Website</h1>
      </header>
      <div className="container">
        <div className="left-column">
          {/* Add content for the left column here */}
        </div>
        <div className="movie-container">
          {movies.map((movie) => (
            <div className="movie-card" key={movie.id} onClick={() => handleCardClick(movie)}>
              <img src={process.env.PUBLIC_URL + '/' + movie.poster} alt={movie.title} className="movie-image" />
              <div className="movie-title">{movie.title}</div>
              <div className="movie-hover-details">
                <p><strong>Summary:</strong> {movie.summary}</p>
              </div>
            </div>
          ))}
        </div>
        <div className="right-column">
          {/* Add content for the right column (filter bar) here */}
        </div>
      </div>
      {selectedMovie && (
        <div className="modal" onClick={handleClosePopup}>
          <div className="modal-content" onClick={(e) => e.stopPropagation()}>
            <span className="close" onClick={handleClosePopup}>&times;</span>
            <img src={process.env.PUBLIC_URL + '/' + selectedMovie.poster} alt={selectedMovie.title} />
            <h3>{selectedMovie.title}</h3>
            <p><strong>Duration:</strong> {selectedMovie.duration}</p>
            <p><strong>Average Stars:</strong> {'★'.repeat(selectedMovie.stars)}</p>
            <p><strong>Summary:</strong> {selectedMovie.summary}</p>
            <p><strong>Year of Release:</strong> {selectedMovie.release_year}</p>
            <p><strong>Language:</strong> {selectedMovie.language}</p> {/* Add this line */}
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
