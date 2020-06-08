package com.alexmanwell.impvocabapp.model;

public class Word {

    private final int id;
    private final String name;
    private final String transcription;
    private final Explanation explanation;
    private final PartOfSpeech partOfSpeech;

    public Word(int id, String name, String transcription, Explanation explanation, PartOfSpeech partOfSpeech) {
        this.id = id;
        this.name = name;
        this.transcription = transcription;
        this.explanation = explanation;
        this.partOfSpeech = partOfSpeech;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTranscription() {
        return transcription;
    }

    public Explanation getExplanation() {
        return explanation;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }
}