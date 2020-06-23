CREATE TABLE part_of_speech (
  abbr        CHARACTER VARYING(30) PRIMARY KEY,
  name CHARACTER VARYING(255) NOT NULL
);

CREATE TABLE words (
  id            SERIAl PRIMARY KEY,
  name          CHARACTER VARYING(255) NOT NULL,
  transcription CHARACTER VARYING(255),
  abbr CHARACTER VARYING(10),
  UNIQUE (name, transcription, abbr),
  FOREIGN KEY (abbr) REFERENCES part_of_speech (abbr)
);

CREATE TABLE explanations (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(255),
  word_id INTEGER NOT NULL,
  FOREIGN KEY (word_id) REFERENCES words (id)
);

CREATE TABLE examples (
  id      SERIAL PRIMARY KEY,
  expl_id INTEGER,
  name    CHARACTER VARYING(511) UNIQUE,
  FOREIGN KEY (expl_id) REFERENCES explanations (id)
);

CREATE TABLE translations (
  id SERIAL PRIMARY KEY,
  word_id INTEGER NOT NULL,
  translate_word_id INTEGER NOT NULL,
  FOREIGN KEY (word_id) REFERENCES words (id),
  FOREIGN KEY (translate_word_id) REFERENCES words (id)
);

