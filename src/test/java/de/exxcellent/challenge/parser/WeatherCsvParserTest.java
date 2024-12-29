package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.data.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherCsvParserTest {

    @Test
    public void testParseValidLine() {
        // arrange
        String line = "1,30,10";
        WeatherCsvParser parser = new WeatherCsvParser();
        WeatherRecord result = parser.parse(line);

        assertEquals(1, result.dayOfMonth());
        assertEquals(30, result.maxTemp());
        assertEquals(10, result.minTemp());
    }
}
