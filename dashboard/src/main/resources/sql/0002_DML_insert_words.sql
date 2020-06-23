/*Insert data in the words table and data cascaded tables*/

INSERT INTO words(name, transcription, abbr) VALUES ('pure', 'pjʊə', 'adj');
  INSERT INTO explanations(name, word_id) VALUES ('not mixed or adulterated with any other substance or material.', 1);
    INSERT INTO examples(expl_id, name) VALUES (1, 'By pure chance, I also received a letter from the UK today.');
    INSERT INTO examples(expl_id, name) VALUES (1, 'They have done so as a result of pure graft and sheer talent.');
    INSERT INTO examples(expl_id, name) VALUES (1, 'The material felt like pure silk, completely smooth.');


INSERT INTO words(name, transcription, abbr) VALUES ('poor', 'pʊə', 'adj');
  INSERT INTO explanations(name, word_id) VALUES ('worse than is usual, expected, or desirable; of a low or inferior standard or quality.', 2);
    INSERT INTO examples(expl_id, name) VALUES (2, 'Ignatius Street was a particular problem area with the quality of lighting very poor at each end of it');


INSERT INTO words(name, transcription, abbr) VALUES ('police', 'pəˈliːs', 'n');
  INSERT INTO explanations(name, word_id) VALUES ('the civil force of a national or local government, responsible for the prevention and detection of crime and the maintenance of public order.', 3);
    INSERT INTO examples(expl_id, name) VALUES (3, 'A manifest example of such activities is provided by the armed forces and the police.');
  INSERT INTO explanations(name, word_id) VALUES ('the organisation which protects people from criminals, finds who committed crimes, etc.', 3);


INSERT INTO words(name, transcription, abbr) VALUES ('government', 'ˈgʌv(ə)mənt', 'n');
  INSERT INTO explanations(name, word_id) VALUES ('the group of people who manage the economy and politics of a country.', 4);
    INSERT INTO examples(expl_id, name) VALUES (4, 'A second shift is to move tax and spending from federal government to states and towns.');
  INSERT INTO explanations(name, word_id) VALUES ('the governing body of a nation, state, or community.', 4);
    INSERT INTO examples(expl_id, name) VALUES (6, 'Liberal Democrats in government in Scotland have set the new agenda for devolution.');
    INSERT INTO examples(expl_id, name) VALUES (6, 'Armed anti-terrorist police swooped on a Rochdale business to arrest a 30-year-old warehouse worker.');


INSERT INTO words(name, transcription, abbr) VALUES ('go', 'gəʊ', 'v');
  INSERT INTO explanations(name, word_id) VALUES ('to move or travel to a place', 5);
    INSERT INTO examples(expl_id, name) VALUES (7, 'You were wrong. When you need capital, you go to your friends.');
    INSERT INTO examples(expl_id, name) VALUES (7, 'Believe me. You don''t want to go there');
    INSERT INTO examples(expl_id, name) VALUES (7, 'We told her we were thinking about going to France to visit my grandfather''s grave.');
  INSERT INTO explanations(name, word_id) VALUES ('a change of place, position, or state.', 5);
    INSERT INTO examples(expl_id, name) VALUES (8, 'the furniture go down six feet.');


INSERT INTO words(name, transcription, abbr) VALUES ('go', 'gəʊ', 'n');
  INSERT INTO explanations(name, word_id) VALUES ('an attempt or trial at something.', 6);
    INSERT INTO examples(expl_id, name) VALUES (9, 'I was reluctant at first as the staff were nearly all youngsters in their teens and early twenties, but I decided to give it a go.');
    INSERT INTO examples(expl_id, name) VALUES (9, 'Don''t make any sudden moves and do not scream and I will not hurt you.');


INSERT INTO words(name, transcription, abbr) VALUES ('go', 'gəʊ', 'adj');
  INSERT INTO explanations(name, word_id) VALUES ('functioning properly.', 7);
    INSERT INTO examples(expl_id, name) VALUES (10, 'It is all systems go here in Dublin. We have moved into new premises and are commencing our advertising and marketing campaign.');

/*-------------------------------------------------------------------------------------------------*/
/*Insert data in the words table RUSSIAN WORDS*/
INSERT INTO words(name) VALUES ('чистый');
INSERT INTO words(name) VALUES ('бедный');
INSERT INTO words(name) VALUES ('идти');
INSERT INTO words(name) VALUES ('перемещение');
INSERT INTO words(name) VALUES ('функциональное свойство');

/*-------------------------------------------------------------------------------------------------*/
/*Insert data in the translate_word table*/

INSERT INTO translations(word_id, translate_word_id) VALUES (1, 8); /*pure - чистый*/
INSERT INTO translations(word_id, translate_word_id) VALUES (2, 9); /*poor - бедный*/
INSERT INTO translations(word_id, translate_word_id) VALUES (5, 10); /*go - идти*/
INSERT INTO translations(word_id, translate_word_id) VALUES (6, 11); /*go - перемещение*/
INSERT INTO translations(word_id, translate_word_id) VALUES (7, 12); /*go - функционально свойство*/

/*-------------------------------------------------------------------------------------------------*/