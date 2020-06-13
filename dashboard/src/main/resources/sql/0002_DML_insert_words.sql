/*Insert data in the words table*/

INSERT INTO words(name, transcription, part_id) VALUES ('pure', 'pjʊə', 3);
INSERT INTO words(name, transcription, part_id) VALUES ('poor', 'pʊə', 3);
INSERT INTO words(name, transcription, part_id) VALUES ('police', 'pəˈliːs', 2);
INSERT INTO words(name, transcription, part_id) VALUES ('government', 'ˈgʌv(ə)mənt', 2);
INSERT INTO words(name, transcription, part_id) VALUES ('go', 'gəʊ', 1);
INSERT INTO words(name, transcription, part_id) VALUES ('go', 'gəʊ', 2);
INSERT INTO words(name, transcription, part_id) VALUES ('go', 'gəʊ', 3);

/*-------------------------------------------------------------------------------------------------*/
/*Insert data in the words table RUSSIAN WORDS*/

INSERT INTO words(name) VALUES ('чистый');
INSERT INTO words(name) VALUES ('бедный');
INSERT INTO words(name) VALUES ('идти');
INSERT INTO words(name) VALUES ('перемещение');
INSERT INTO words(name) VALUES ('функциональное свойство');

/*-------------------------------------------------------------------------------------------------*/
/*Insert data in the translate_word table*/

INSERT INTO translate_word(from_id_word, to_id_word) VALUES (1, 8);
INSERT INTO translate_word(from_id_word, to_id_word) VALUES (2, 9);
INSERT INTO translate_word(from_id_word, to_id_word) VALUES (5, 10);
INSERT INTO translate_word(from_id_word, to_id_word) VALUES (6, 11);
INSERT INTO translate_word(from_id_word, to_id_word) VALUES (7, 12);
