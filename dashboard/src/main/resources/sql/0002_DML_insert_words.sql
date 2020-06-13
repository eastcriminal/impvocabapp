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

/*-------------------------------------------------------------------------------------------------*/
/*Insert data in the explanation table*/

INSERT INTO explanation(name, word_id) VALUES ('not mixed or adulterated with any other substance or material.', 1);
INSERT INTO explanation(name, word_id) VALUES ('worse than is usual, expected, or desirable; of a low or inferior standard or quality.', 2);
INSERT INTO explanation(name, word_id)
  VALUES ('the civil force of a national or local government, responsible for the prevention and detection of crime and the maintenance of public order.', 3);
INSERT INTO explanation(name, word_id) VALUES ('the group of people who manage the economy and politics of a country.', 4);
INSERT INTO explanation(name, word_id) VALUES ('to move or travel to a place', 5);
INSERT INTO explanation(name, word_id) VALUES ('the organisation which protects people from criminals, finds who committed crimes, etc.', 3);
INSERT INTO explanation(name, word_id) VALUES ('the governing body of a nation, state, or community.', 4);
INSERT INTO explanation(name, word_id) VALUES ('an attempt or trial at something.', 6);
INSERT INTO explanation(name, word_id) VALUES ('functioning properly.', 7);
INSERT INTO explanation(name, word_id) VALUES ('a change of place, position, or state.', 5);

/*-------------------------------------------------------------------------------------------------*/
/*Insert data in the example table*/

INSERT INTO example(expl_id, name) VALUES (1, 'By pure chance, I also received a letter from the UK today.');
INSERT INTO example(expl_id, name)
  VALUES (2, 'Ignatius Street was a particular problem area with the quality of lighting very poor at each end of it');
INSERT INTO example(expl_id, name)
  VALUES (3, 'A manifest example of such activities is provided by the armed forces and the police.');
INSERT INTO example(expl_id, name)
  VALUES (4, 'A second shift is to move tax and spending from federal government to states and towns.');
INSERT INTO example(expl_id, name) VALUES (5, 'You were wrong. When you need capital, you go to your friends.');
INSERT INTO example(expl_id, name)
  VALUES (6, 'Armed anti-terrorist police swooped on a Rochdale business to arrest a 30-year-old warehouse worker.');
INSERT INTO example(expl_id, name) VALUES (7, 'Liberal Democrats in government in Scotland have set the new agenda for devolution.');
INSERT INTO example(expl_id, name) VALUES (1, 'They have done so as a result of pure graft and sheer talent.');
INSERT INTO example(expl_id, name) VALUES (1, 'The material felt like pure silk, completely smooth.');
INSERT INTO example(expl_id, name)
  VALUES (8, 'I was reluctant at first as the staff were nearly all youngsters in their teens and early twenties, but I decided to give it a go.');
INSERT INTO example(expl_id, name)
  VALUES (9, 'It is all systems go here in Dublin. We have moved into new premises and are commencing our advertising and marketing campaign.');
INSERT INTO example(expl_id, name) VALUES (5, 'Believe me. You don''t want to go there');
INSERT INTO example(expl_id, name)
  VALUES (5, 'We told her we were thinking about going to France to visit my grandfather''s grave.');
INSERT INTO example(expl_id, name) VALUES (8, 'Don''t make any sudden moves and do not scream and I will not hurt you.');
INSERT INTO example(expl_id, name) VALUES (10, 'the furniture go down six feet.');

/*-------------------------------------------------------------------------------------------------*/