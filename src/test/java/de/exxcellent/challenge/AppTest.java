package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example JUnit 5 test case.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void runWeather() {
        String[] args = {"--weather", "de/exxcellent/challenge/weather.csv"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            App.main(args);

            String output = outputStream.toString();
            assertTrue(output.contains("Day with smallest temperature spread : 14"),
                    "Output should contain 'Day with smallest temperature spread : 14'");
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void runFootball() {
        String[] args = {"--football", "de/exxcellent/challenge/football.csv"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            App.main(args);

            String output = outputStream.toString();
            assertTrue(output.contains("Team with smallest goal spread       : Aston_Villa"),
                    "Output should contain 'Team with smallest goal spread       : Aston_Villa'");
        } finally {
            System.setOut(originalOut);
        }
    }

}