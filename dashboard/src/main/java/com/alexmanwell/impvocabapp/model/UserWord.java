package com.alexmanwell.impvocabapp.model;

import java.util.Collection;

public class UserWord {

    private final int id;
    private final User user;
    private final Word word;
    private final Collection<TextExample> examples;

    public UserWord(int id, User user, Word word, Collection<TextExample> examples) {
        this.id = id;
        this.user = user;
        this.word = word;
        this.examples = examples;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Word getWord() {
        return word;
    }

    public Collection<TextExample> getExamples() {
        return examples;
    }
}