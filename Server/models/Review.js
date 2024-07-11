const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ReviewSchema = new Schema({
  review: { type: String, required: true },
  rating: { type: Number, required: true },
  movieReviewId: { type: String, required: true }
});

module.exports = mongoose.model('Review', ReviewSchema);
