package de.exxcellent.challenge;

import org.junit.jupiter.api.Disabled;
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
    @Disabled
    void runFootball() {
        App.main("--football", "de/exxcellent/challenge/football.csv");
    }

}