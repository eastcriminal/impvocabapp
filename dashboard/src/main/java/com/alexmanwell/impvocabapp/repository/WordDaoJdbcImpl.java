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

    @Override
    public Collection<Word> printAll() throws SQLException {
        Collection<Word> words = new HashSet<>();
        final String SELECT_ALL_WORDS =
                "SELECT w.id AS wid, w.name, w.transcription, pos.name AS part_of_speech, " +
                        "expl.id AS expl_id, expl.name AS explain, example.name AS example " +
                        "FROM words AS w " +
                        "INNER JOIN part_of_speech AS pos ON w.part_id = pos.id " +
                        "INNER JOIN explanation AS expl ON w.id = expl.word_id " +
                        "INNER JOIN example ON expl.id = example.expl_id;";
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_WORDS);
             ResultSet rs = ps.executeQuery()) {
            Map<Integer, Collection<TextExample>> examples = new HashMap<>();
            Map<Map<Integer, Integer>, Explanation> explanations = new HashMap<>();
            Map<Integer, Collection<Explanation>> explanationsOfWord = new HashMap<>();
            while (rs.next()) {
                int id = rs.getInt("wid");
                int explanationId = rs.getInt("expl_id");
                PartOfSpeech partOfSpeech = PartOfSpeech.valueOf(rs.getString("part_of_speech").toUpperCase());
                String transcription = rs.getString("transcription");
                String name = rs.getString("name");

                Collection<TextExample> examplesOfExplanation = examples.get(explanationId);
                if (examplesOfExplanation == null) {
                    examplesOfExplanation = new HashSet<>();
                }
                examplesOfExplanation.add(new TextExample(rs.getString("example")));
                examples.put(explanationId, examplesOfExplanation);

                Explanation explanation = explanations.get(Collections.singletonMap(id, explanationId));
                if (explanation == null) {
                    explanation = new Explanation(rs.getString("explain"), examples.get(explanationId));
                }
                explanations.put(Collections.singletonMap(id, explanationId), explanation);

                Collection<Explanation> explainList = explanationsOfWord.get(id);
                if (explainList == null) {
                    explainList = new HashSet<>();
                }
                explainList.add(explanation);
                explanationsOfWord.put(id, explainList);

                words.add(new Word(id, name, transcription, explanationsOfWord.get(id), partOfSpeech));
            }
        }
        return Collections.unmodifiableCollection(words);
    }
}