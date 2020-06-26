package com.alexmanwell.impvocabapp.repository;

import com.alexmanwell.impvocabapp.model.User;
import com.alexmanwell.impvocabapp.model.Word;

import java.sql.SQLException;

public interface UserWordDao {

    boolean addWord(User user, Word word) throws SQLException;
}