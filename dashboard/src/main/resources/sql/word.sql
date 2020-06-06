CREATE TABLE part_of_speech(
  id          SERIAl PRIMARY KEY,
  name        CHARACTER VARYING(30) UNIQUE  NOT NULL,
  explanation CHARACTER VARYING(255) UNIQUE NOT NULL
);

CREATE TABLE words(
  id            SERIAl,
  name          CHARACTER VARYING(255) NOT NULL,
  transcription CHARACTER VARYING(255),
  explanation   CHARACTER VARYING(255),
  part_id       INTEGER,
  PRIMARY KEY (name, explanation, part_id),
  FOREIGN KEY (part_id) REFERENCES part_of_speech (id)
);