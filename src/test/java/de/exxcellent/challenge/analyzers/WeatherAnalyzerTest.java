package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.data.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherAnalyzerTest {

    @Test
    public void testDayWithSmallestTempSpread() {
        List<WeatherRecord> records = List.of(
                new WeatherRecord(1, 30, 10), // spread: 20
                new WeatherRecord(2, 25, 15), // spread: 10
                new WeatherRecord(3, 28, 20)  // spread: 8
        );

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        int result = analyzer.analyze(records);
        assertEquals(3, result, "Day with the smallest temperature spread should be 3");
    }

    @Test
    public void testDaysWithEqualTempSpread() {
        List<WeatherRecord> records = List.of(
                new WeatherRecord(1, 30, 20), // spread: 10
                new WeatherRecord(2, 28, 18), // spread: 10
                new WeatherRecord(3, 26, 15)  // spread: 11
        );

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        int result = analyzer.analyze(records);
        assertEquals(1, result, "The first day with the smallest temperature spread should be 1");
    }

    @Test
    public void testNegativeTemperatures() {
        List<WeatherRecord> records = List.of(
                new WeatherRecord(1, -10, -20), // spread: 10
                new WeatherRecord(2, -5, -15),  // spread: 10
                new WeatherRecord(3, 0, -10)    // spread: 10
        );

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        int result = analyzer.analyze(records);
        assertEquals(1, result, "The first day with the smallest temperature spread should be 1");
    }

    @Test
    public void testEmptyList() {
        List<WeatherRecord> records = List.of();

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analyzer.analyze(records)
        );
        assertEquals("Records must not be null or empty", exception.getMessage());
    }

    @Test
    public void testSingleDay() {
        List<WeatherRecord> records = List.of(
                new WeatherRecord(1, 30, 20)
        );

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        int result = analyzer.analyze(records);
        assertEquals(1, result, "The only day should be returned");
    }

    @Test
    public void testMaxTempLessThanMinTemp() {
        List<WeatherRecord> records = List.of(
                new WeatherRecord(1, 10, 30), // maxTemp < minTemp
                new WeatherRecord(2, 25, 15), // spread: 10
                new WeatherRecord(3, 28, 20)  // spread: 8
        );

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        int result = analyzer.analyze(records);
        assertEquals(3, result, "Day 3 should have the smallest temperature spread");
    }

}
