package com.alexmanwell.impvocabapp.repository;

import com.alexmanwell.impvocabapp.model.*;

import java.sql.*;

public class UserWordDaoJdbcImpl implements UserWordDao {

    private final Connection connection;

    public UserWordDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addWord(User user, Word word) throws SQLException {
        try (
                PreparedStatement psExamples = connection.prepareStatement("INSERT INTO examples (expl_id, name) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                PreparedStatement psUserDictionary = connection.prepareStatement("INSERT INTO users_dictionary (nickname, word_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                PreparedStatement psUserExamples = connection.prepareStatement("INSERT INTO user_examples (user_dictionary_id, example_id) VALUES (?, ?)")
        ) {
            psUserDictionary.setString(1, user.getNickname());
            psUserDictionary.setInt(2, word.getId());
            psUserDictionary.executeUpdate();

            ResultSet generateUserDictionaryKeys = psUserDictionary.getGeneratedKeys();
            generateUserDictionaryKeys.next();
            int userDictionaryId = generateUserDictionaryKeys.getInt("id");
            for (Explanation expl : word.getExplanation()) {
                for(TextExample textExample : expl.getExamples()) {
                    psExamples.setInt(1, expl.getId());
                    psExamples.setString(2, textExample.getText());
                    psExamples.getGeneratedKeys();
                    psExamples.executeUpdate();

                    ResultSet generateExampleKeys = psExamples.getGeneratedKeys();
                    generateExampleKeys.next();

                    int exampleId = generateExampleKeys.getInt("id");
                    psUserExamples.setInt(1, userDictionaryId);
                    psUserExamples.setInt(2, exampleId);
                    psUserExamples.executeUpdate();
                }
            }
        }

        return true;
    }
}