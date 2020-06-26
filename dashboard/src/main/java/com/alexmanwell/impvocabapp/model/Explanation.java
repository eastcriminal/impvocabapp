package com.alexmanwell.impvocabapp.model;

import java.util.Collection;
import java.util.Collections;

public class Explanation {

    private final int id;
    private final String explanation;
    private final Collection<TextExample> examples;

    public Explanation(int id, String explanation, Collection<TextExample> examples) {
        this.id = id;
        this.explanation = explanation;
        this.examples = examples;
    }

    public int getId() {
        return id;
    }

    public String getExplanation() {
        return explanation;
    }

    public Collection<TextExample> getExamples() {
        return Collections.unmodifiableCollection(examples);
    }
}