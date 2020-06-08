package com.alexmanwell.impvocabapp.model;

public class UserWord {

    private final int id;
    private final User user;
    private final Word word;
    private final TextExample example;

    public UserWord(int id, User user, Word word, TextExample example) {
        this.id = id;
        this.user = user;
        this.word = word;
        this.example = example;
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

    public TextExample getExample() {
        return example;
    }
}