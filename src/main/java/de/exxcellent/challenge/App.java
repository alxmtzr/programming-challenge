package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzers.Analyzer;
import de.exxcellent.challenge.analyzers.FootballAnalyzer;
import de.exxcellent.challenge.analyzers.WeatherAnalyzer;
import de.exxcellent.challenge.data.model.FootballTeam;
import de.exxcellent.challenge.data.model.WeatherRecord;
import de.exxcellent.challenge.parser.FootballCsvParser;
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
        if (args.length < 2) {
            System.err.println("Usage: App --weather <path-to-weather-csv> | --football <path-to-football-csv>");
            System.exit(1);
        }

        switch (args[0].toLowerCase()) {
            case "--weather":
                handleWeather(args[1]);
                break;
            case "--football":
                handleFootball(args[1]);
                break;
            default:
                System.err.println("Invalid option. Use --weather or --football.");
                System.exit(1);
        }
    }


    private static void handleWeather(String filePath) {
        DataReader<WeatherRecord> reader = new CsvReader<>(new WeatherCsvParser());
        List<WeatherRecord> weatherData = reader.fromResources(filePath);

        Analyzer<WeatherRecord, Integer> weatherAnalyzer = new WeatherAnalyzer();
        int dayWithSmallestTempSpread = weatherAnalyzer.analyze(weatherData);
        System.out.printf("Day with smallest temperature spread : %d%n", dayWithSmallestTempSpread);
    }

    private static void handleFootball(String filePath) {
        DataReader<FootballTeam> reader = new CsvReader<>(new FootballCsvParser());
        List<FootballTeam> footballData = reader.fromResources(filePath);

        Analyzer<FootballTeam, String> footballAnalyzer = new FootballAnalyzer();
        String teamWithSmallestGoalSpread = footballAnalyzer.analyze(footballData);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
