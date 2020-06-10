CREATE TABLE part_of_speech (
  id          SERIAl PRIMARY KEY,
  name        CHARACTER VARYING(30) UNIQUE  NOT NULL,
  explanation CHARACTER VARYING(255) UNIQUE NOT NULL
);

CREATE TABLE words (
  id            SERIAl PRIMARY KEY,
  name          CHARACTER VARYING(255) NOT NULL,
  transcription CHARACTER VARYING(255),
  part_id INTEGER,
  UNIQUE (name, transcription, part_id),
  FOREIGN KEY (part_id) REFERENCES part_of_speech (id)
);

CREATE TABLE explanation (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(255),
  word_id INTEGER NOT NULL,
  FOREIGN KEY (word_id) REFERENCES words (id)
);

CREATE TABLE example (
  id      SERIAL PRIMARY KEY,
  expl_id INTEGER,
  name    CHARACTER VARYING(511) UNIQUE,
  FOREIGN KEY (expl_id) REFERENCES explanation (id)
);
