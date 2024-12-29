package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.data.model.WeatherRecord;
import de.exxcellent.challenge.parser.WeatherCsvParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvReaderTest {
    private static final String WEATHER_FILE = "de/exxcellent/challenge/weather.csv";
    private static final String FOOTBALL_FILE = "de/exxcellent/challenge/football.csv";

    @Test
    public void testReadWeatherData() {
        final DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());
        final List<WeatherRecord> weatherData = reader.read(WEATHER_FILE);

        assertEquals(30, weatherData.size(), "Weather data should have 30 records");
        assertEquals(88, weatherData.get(0).maxTemp(), "First record should have max temp 88");
        assertEquals(59, weatherData.get(0).minTemp(), "First record should have min temp 59");
    }
}
