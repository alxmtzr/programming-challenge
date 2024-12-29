package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.data.model.WeatherRecord;

/**
 * Parses a line of a CSV file into a {@link WeatherRecord}.
 */
public class WeatherCsvParser implements CsvParser<WeatherRecord> {

    @Override
    public WeatherRecord parse(String line) {
        try {
            String[] parts = line.split(",");
            int day = Integer.parseInt(parts[0].trim());
            int maxTemp = Integer.parseInt(parts[1].trim());
            int minTemp = Integer.parseInt(parts[2].trim());
            return new WeatherRecord(day, maxTemp, minTemp);
        } catch (NumberFormatException e) {
            return null; // Skip invalid lines
        }
    }
}
