CREATE TABLE users (
  nickname CHARACTER VARYING(30) PRIMARY KEY,
  mail CHARACTER VARYING (99) UNIQUE NOT NULL,
  password CHARACTER VARYING (255) NOT NULL
);

CREATE TABLE users_dictionary (
  id SERIAL PRIMARY KEY,
  nickname CHARACTER VARYING(30) NOT NULL,
  word_id INTEGER NOT NUll,
  FOREIGN KEY (nickname) REFERENCES users(nickname),
  FOREIGN KEY (word_id) REFERENCES words(id)
);

CREATE TABLE user_examples (
  id SERIAL PRIMARY KEY,
  user_dictionary_id INTEGER NOT NUll,
  example_id INTEGER NOT NULL,
  FOREIGN KEY (user_dictionary_id) REFERENCES users_dictionary(id),
  FOREIGN KEY (example_id) REFERENCES examples(id)
);