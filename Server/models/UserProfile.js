const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const UserProfileSchema = new Schema({
  likes: { type: [String], required: true },
  uid: { type: String, required: true, unique: true },
  movieReviewIds: { type: [String], required: true }
});

module.exports = mongoose.model('UserProfile', UserProfileSchema);
