package com.alexmanwell.impvocabapp.model;

public class User {

    private final String nickname;
    private final String mail;

    public User(String nickname, String mail) {
        this.nickname = nickname;
        this.mail = mail;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMail() {
        return mail;
    }
}