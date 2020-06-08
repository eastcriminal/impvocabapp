package com.alexmanwell.impvocabapp.model;

import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.EMPTY_LIST;

public class Explanation {

    private final String explanation;
    private final Collection<TextExample> examples;

    public Explanation(String explanation, Collection<TextExample> examples) {
        this.explanation = explanation;
        this.examples = examples;
    }

    public Explanation(String explanation) {
        this(explanation, EMPTY_LIST);
    }

    public String getExplanation() {
        return explanation;
    }

    public Collection<TextExample> getExamples() {
        return Collections.unmodifiableCollection(examples);
    }
}