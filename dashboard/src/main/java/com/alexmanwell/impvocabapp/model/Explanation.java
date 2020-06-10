package com.alexmanwell.impvocabapp.model;

import java.util.Collection;
import java.util.Collections;

public class Explanation {

    private final String explanation;
    private final Collection<TextExample> examples;

    public Explanation(String explanation, Collection<TextExample> examples) {
        this.explanation = explanation;
        this.examples = examples;
    }

    public String getExplanation() {
        return explanation;
    }

    public Collection<TextExample> getExamples() {
        return Collections.unmodifiableCollection(examples);
    }
}