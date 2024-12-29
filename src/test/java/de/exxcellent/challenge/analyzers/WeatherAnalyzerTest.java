package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.data.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAnalyzerTest {

    @Test
    public void testDayWithSmallestTempSpread() {
        List<WeatherRecord> records = List.of(
                new WeatherRecord(1, 30, 10),
                new WeatherRecord(2, 25, 15),
                new WeatherRecord(3, 28, 20) // smallest spread
        );

        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        int result = analyzer.analyze(records);
        assertEquals(3, result, "Day with the smallest temperature spread should be 3");
    }
}
