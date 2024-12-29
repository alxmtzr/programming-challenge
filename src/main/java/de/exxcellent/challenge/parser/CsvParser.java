package de.exxcellent.challenge.parser;

/**
 * Interface for parsing a line of a CSV file into a record.
 */
public interface CsvParser<T> {
    T parse(String line);
}
