package com.alexmanwell.impvocabapp.repository;

import com.alexmanwell.impvocabapp.model.Word;

import java.sql.SQLException;
import java.util.Collection;

public interface WordDao {

    Collection<Word> printAll() throws SQLException;

    Collection<Word> findWordsByName(final String name) throws SQLException;
}