const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const MovieSchema = new Schema({
  movieId: { type: String, required: true, unique: true },
  title: { type: String, required: true },
  description: { type: String, required: true },
  cast: { type: [String], required: true },
  reviewIds: { type: [String], required: true },
  themes: { type: [String], required: true },
  genre: { type: [String], required: true },
  avgRating: { type: Number, required: true }
});

module.exports = mongoose.model('Movie', MovieSchema);
