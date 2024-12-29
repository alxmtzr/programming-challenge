package de.exxcellent.challenge.reader;

import java.util.List;

/**
 * Interface for reading data from a source and returning a list of records.
 */
public interface DataReader<T> {
    List<T> read(String source);
}
