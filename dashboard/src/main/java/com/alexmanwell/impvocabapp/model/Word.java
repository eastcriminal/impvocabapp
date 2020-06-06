package com.alexmanwell.impvocabapp.model;

public class Word {

    private final int id;
    private final String name;
    private final String transcription;
    private final String explanation;
    private final String partOfSpeech;

    public Word(int id, String name, String transcription, String explanation, String partOfSpeech) {
        this.id = id;
        this.name = name;
        this.transcription = transcription;
        this.explanation = explanation;
        this.partOfSpeech = partOfSpeech;
    }

    public String getName() {
        return name;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}