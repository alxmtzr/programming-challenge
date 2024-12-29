package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzers.Analyzer;
import de.exxcellent.challenge.analyzers.WeatherAnalyzer;
import de.exxcellent.challenge.data.model.WeatherRecord;
import de.exxcellent.challenge.parser.WeatherCsvParser;
import de.exxcellent.challenge.reader.CsvReader;
import de.exxcellent.challenge.reader.DataReader;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        if ("--weather".equalsIgnoreCase(args[0])) {
            DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());
            List<WeatherRecord> weatherData = reader.read(args[1]);

            Analyzer<WeatherRecord, Integer> weatherAnalyzer = new WeatherAnalyzer();
            int dayWithSmallestTempSpread = weatherAnalyzer.analyze(weatherData);
            System.out.printf("Day with smallest temperature spread : %d%n", dayWithSmallestTempSpread);
        } else if ("--football".equalsIgnoreCase(args[0])) {
            // Placeholder for football case
            String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        }
    }
}
