package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.data.model.WeatherRecord;
import de.exxcellent.challenge.parser.WeatherCsvParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {
    private static final String VALID_WEATHER_FILE = "de/exxcellent/challenge/weather.csv";
    private static final String EMPTY_FILE = "de/exxcellent/challenge/test_files/empty.csv";
    private static final String INVALID_FILE = "de/exxcellent/challenge/test_files/invalid.csv";
    private static final String MISSING_FILE = "de/exxcellent/challenge/test_files/missing.csv";

    @Test
    public void testReadWeatherData() {
        final DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());
        final List<WeatherRecord> weatherData = reader.fromResources(VALID_WEATHER_FILE);

        assertEquals(30, weatherData.size(), "Weather data should have 30 records");
        assertEquals(88, weatherData.get(0).maxTemp(), "First record should have max temp 88");
        assertEquals(59, weatherData.get(0).minTemp(), "First record should have min temp 59");
    }

    @Test
    public void testEmptyFile() {
        final DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());
        final List<WeatherRecord> weatherData = reader.fromResources(EMPTY_FILE);

        assertTrue(weatherData.isEmpty(), "Weather data should be empty for an empty file");
    }

    @Test
    public void testFileNotFound() {
        final DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());

        assertThrows(RuntimeException.class, () -> reader.fromResources(MISSING_FILE), "Missing file should throw an exception");
    }

    @Test
    public void testPartiallyInvalidFile() {
        final DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());
        final List<WeatherRecord> weatherData = reader.fromResources(INVALID_FILE);

        // there should be 3 valid records
        assertEquals(3, weatherData.size(), "Weather data should only include valid records");

        assertEquals(88, weatherData.get(0).maxTemp(), "First valid record max temp should be 88");
        assertEquals(80, weatherData.get(1).maxTemp(), "Second valid record max temp should be 80");
        assertEquals(81, weatherData.get(2).maxTemp(), "Third valid record max temp should be 81");
    }
}
