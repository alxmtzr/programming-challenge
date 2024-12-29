package de.exxcellent.challenge.analyzers;

import java.util.List;

public interface Analyzer<T, R> {
    R analyze(List<T> records);
}
