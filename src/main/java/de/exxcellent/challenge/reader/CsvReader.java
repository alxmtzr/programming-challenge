package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.parser.CsvParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads data from a CSV file and returns a list of records.
 */
public class CsvReader<T> implements DataReader<T> {

    private final CsvParser<T> parser;

    public CsvReader(CsvParser<T> parser) {
        this.parser = parser;
    }

    @Override
    public List<T> read(String source) {
        List<T> records = new ArrayList<>();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(source)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                T record = parser.parse(line);
                records.add(record);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file: " + source, e);
        }
        return records;
    }
}
