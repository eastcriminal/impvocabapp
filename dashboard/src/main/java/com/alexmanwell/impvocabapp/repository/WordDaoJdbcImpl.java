package com.alexmanwell.impvocabapp.repository;

import com.alexmanwell.impvocabapp.model.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WordDaoJdbcImpl implements WordDao {

    private final Connection connection;

    public WordDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Collection<Word> printAll() throws SQLException {
        Collection<Word> words = new ArrayList<>();
        final String SELECT_ALL_WORDS =
                "SELECT w.id AS wid, w.name, w.transcription, w.explanation, pos.name AS part_of_speech " +
                        "FROM words AS w INNER JOIN part_of_speech pos ON w.part_id = pos.id";
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_WORDS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Word word = new Word(
                        rs.getInt("wid"),
                        rs.getString("name"),
                        rs.getString("transcription"),
                        rs.getString("explanation"),
                        rs.getString("part_of_speech")
                );
                words.add(word);
            }
        }
        return Collections.unmodifiableCollection(words);
    }
}