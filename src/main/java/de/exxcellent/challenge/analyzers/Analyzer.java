package de.exxcellent.challenge.analyzers;

import java.util.List;

/**
 * Interface for analyzers that analyze a list of records and return a result.
 *
 * @param <T> the type of the records to analyze
 * @param <R> the type of the result
 */
public interface Analyzer<T, R> {
    R analyze(List<T> records);
}
