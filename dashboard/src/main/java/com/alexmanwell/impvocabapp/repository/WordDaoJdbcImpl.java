package com.alexmanwell.impvocabapp.repository;

import com.alexmanwell.impvocabapp.model.Explanation;
import com.alexmanwell.impvocabapp.model.PartOfSpeech;
import com.alexmanwell.impvocabapp.model.TextExample;
import com.alexmanwell.impvocabapp.model.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class WordDaoJdbcImpl implements WordDao {

    private final Connection connection;

    public WordDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    private static final String SELECT_ALL_WORDS = "SELECT w.id AS wid, w.name, w.transcription, pos.name AS part_of_speech, " +
            "expl.id AS expl_id, expl.name AS explain, examples.name AS example " +
            "FROM words AS w " +
            "INNER JOIN part_of_speech AS pos ON w.abbr = pos.abbr " +
            "INNER JOIN explanations AS expl ON w.id = expl.word_id " +
            "INNER JOIN examples ON expl.id = examples.expl_id";

    @Override
    public Collection<Word> printAll() throws SQLException {
        final Collection<Word> words;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_WORDS)) {
            words = getWordsExecuteQuery(ps);
        }
        return Collections.unmodifiableCollection(words);
    }

    @Override
    public Collection<Word> findWordsByName(final String name) throws SQLException {
        Collection<Word> words;
        final String SELECT_WORDS_BY_NAME = SELECT_ALL_WORDS + " WHERE w.name = ?;";
        try (PreparedStatement ps = connection.prepareStatement(SELECT_WORDS_BY_NAME)) {
            ps.setString(1, name);
            words = getWordsExecuteQuery(ps);
        }
        return words;
    }

    @Override
    public Map<Word, Word> translate(final String name) throws SQLException {
        final Map<Word, Word> words = new HashMap<>();
        final String SELECT_TRANSLATE_WORDS_BY_NAME =
                "SELECT w.id AS wid, w.name, w.transcription, pos.name AS part_of_speech, expl.id AS expl_id, " +
                        "w2.id AS w2id, w2.name AS translate_name, expl.name AS explain, examples.name AS example " +
                        "FROM translations AS ts " +
                        "INNER JOIN words AS w ON ts.word_id = w.id " +
                        "INNER JOIN words AS w2 ON ts.translate_word_id = w2.id " +
                        "INNER JOIN part_of_speech AS pos ON w.abbr = pos.abbr " +
                        "INNER JOIN explanations AS expl ON w.id = expl.word_id " +
                        "INNER JOIN examples ON expl.id = examples.expl_id " +
                        "WHERE w.name = ?";
        try (PreparedStatement ps = connection.prepareStatement(SELECT_TRANSLATE_WORDS_BY_NAME)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            final Map<Integer, Collection<TextExample>> examples = new HashMap<>();
            final Map<Map<Integer, Integer>, Explanation> explanations = new HashMap<>();
            final Map<Integer, Collection<Explanation>> explanationsOfWord = new HashMap<>();
            while (rs.next()) {
                int id = rs.getInt("wid");
                int explanationId = rs.getInt("expl_id");

                Collection<TextExample> examplesOfExplanation = addExampleToCollection(rs.getString("example"), examples.get(explanationId));
                examples.put(explanationId, examplesOfExplanation);

                Explanation explanation = addExamplesToExplanation(explanationId, rs.getString("explain"), explanations.get(Collections.singletonMap(id, explanationId)), examples.get(explanationId));
                explanations.put(Collections.singletonMap(id, explanationId), explanation);

                Collection<Explanation> list = addExplanationToCollection(explanationsOfWord.get(id), explanation);
                explanationsOfWord.put(id, list);

                words.put(
                        new Word(id,
                                name,
                                rs.getString("transcription"),
                                explanationsOfWord.get(id),
                                PartOfSpeech.valueOf(rs.getString("part_of_speech").toUpperCase())
                        ),
                        new Word(rs.getInt("w2id"),
                                rs.getString("translate_name"),
                                "",
                                new ArrayList<>(),
                                null)
                );
            }
        }
        return words;
    }

    private Collection<Word> getWordsExecuteQuery(final PreparedStatement ps) throws SQLException {
        Collection<Word> words = new HashSet<>();
        try (ResultSet rs = ps.executeQuery()) {
            final Map<Integer, Collection<TextExample>> examples = new HashMap<>();
            final Map<Map<Integer, Integer>, Explanation> explanations = new HashMap<>();
            final Map<Integer, Collection<Explanation>> explanationsOfWord = new HashMap<>();
            while (rs.next()) {
                int id = rs.getInt("wid");
                int explanationId = rs.getInt("expl_id");

                Collection<TextExample> examplesOfExplanation = addExampleToCollection(rs.getString("example"), examples.get(explanationId));
                examples.put(explanationId, examplesOfExplanation);

                Explanation explanation = addExamplesToExplanation(explanationId, rs.getString("explain"), explanations.get(Collections.singletonMap(id, explanationId)), examples.get(explanationId));
                explanations.put(Collections.singletonMap(id, explanationId), explanation);

                Collection<Explanation> list = addExplanationToCollection(explanationsOfWord.get(id), explanation);
                explanationsOfWord.put(id, list);

                Word word = new Word(id,
                                    rs.getString("name"),
                                    rs.getString("transcription"),
                                    explanationsOfWord.get(id),
                                    PartOfSpeech.valueOf(rs.getString("part_of_speech").toUpperCase())
                );
                words.add(word);
            }
        }
        return words;
    }

    private Collection<Explanation> addExplanationToCollection(Collection<Explanation> explanations, final Explanation explanation) {
        if (explanations == null) {
            explanations = new HashSet<>();
        }
        explanations.add(explanation);
        return explanations;
    }

    private Explanation addExamplesToExplanation(int id, final String explain, Explanation explanation, final Collection<TextExample> examples) {
        if (explanation == null) {
            explanation = new Explanation(id, explain, examples);
        }
        return explanation;
    }

    private Collection<TextExample> addExampleToCollection(final String example, Collection<TextExample> examples) {
        if (examples == null) {
            examples= new HashSet<>();
        }
        examples.add(new TextExample(example));
        return examples;
    }
}