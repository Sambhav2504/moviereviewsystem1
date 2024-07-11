const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const UserCredentialsSchema = new Schema({
  username: { type: String, required: true },
  password: { type: String, required: true },
  uid: { type: String, required: true, unique: true }
});

module.exports = mongoose.model('UserCredentials', UserCredentialsSchema);
