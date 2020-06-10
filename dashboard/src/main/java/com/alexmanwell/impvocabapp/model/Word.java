package com.alexmanwell.impvocabapp.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Word {

    private final int id;
    private final String name;
    private final String transcription;
    private final Collection<Explanation> explanations;
    private final PartOfSpeech partOfSpeech;

    public Word(int id, String name, String transcription, Collection<Explanation> explanations, PartOfSpeech partOfSpeech) {
        this.id = id;
        this.name = name;
        this.transcription = transcription;
        this.explanations = explanations;
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

    public Collection<Explanation> getExplanation() {
        return Collections.unmodifiableCollection(explanations);
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return id == word.id &&
                Objects.equals(name, word.name) &&
                Objects.equals(transcription, word.transcription) &&
                partOfSpeech == word.partOfSpeech;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, transcription, partOfSpeech);
    }
}