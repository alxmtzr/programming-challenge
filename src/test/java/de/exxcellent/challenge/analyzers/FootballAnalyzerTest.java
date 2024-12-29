package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.data.model.FootballTeam;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FootballAnalyzerTest {

    @Test
    public void testStandardCase() {
        List<FootballTeam> records = List.of(
                new FootballTeam("TeamA", 10, 5), // difference: 5
                new FootballTeam("TeamB", 8, 6),  // difference: 2
                new FootballTeam("TeamC", 7, 3)   // difference: 4
        );

        FootballAnalyzer analyzer = new FootballAnalyzer();
        String result = analyzer.analyze(records);
        assertEquals("TeamB", result, "Team with the smallest goal difference should be TeamB");
    }

    @Test
    public void testTeamsWithEqualDifferences() {
        List<FootballTeam> records = List.of(
                new FootballTeam("TeamA", 10, 8), // difference: 2
                new FootballTeam("TeamB", 6, 4),  // difference: 2
                new FootballTeam("TeamC", 9, 6)   // difference: 3
        );

        FootballAnalyzer analyzer = new FootballAnalyzer();
        String result = analyzer.analyze(records);
        assertEquals("TeamA", result, "Team with the smallest goal difference should be TeamA (deterministic choice)");
    }

    @Test
    public void testTeamWithZeroDifference() {
        List<FootballTeam> records = List.of(
                new FootballTeam("TeamA", 10, 8), // difference: 2
                new FootballTeam("TeamB", 6, 6),  // difference: 0
                new FootballTeam("TeamC", 9, 6)   // difference: 3
        );

        FootballAnalyzer analyzer = new FootballAnalyzer();
        String result = analyzer.analyze(records);
        assertEquals("TeamB", result, "Team with the smallest goal difference should be TeamB (difference is 0)");
    }

    @Test
    public void testEmptyList() {
        List<FootballTeam> records = List.of();

        FootballAnalyzer analyzer = new FootballAnalyzer();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analyzer.analyze(records)
        );
        assertEquals("Records must not be null or empty", exception.getMessage());
    }

    @Test
    public void testSingleTeam() {
        List<FootballTeam> records = List.of(
                new FootballTeam("TeamA", 10, 8) // difference: 2
        );

        FootballAnalyzer analyzer = new FootballAnalyzer();
        String result = analyzer.analyze(records);
        assertEquals("TeamA", result, "With only one team, that team should be returned");
    }

    @Test
    public void testNegativeGoals() {
        List<FootballTeam> records = List.of(
                new FootballTeam("TeamA", -5, 3), // invalid negative goals
                new FootballTeam("TeamB", 6, 6)  // valid case
        );

        FootballAnalyzer analyzer = new FootballAnalyzer();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analyzer.analyze(records)
        );
        assertEquals("Goals and goals allowed must be non-negative", exception.getMessage());
    }

    @Test
    public void testLargeNumbers() {
        List<FootballTeam> records = List.of(
                new FootballTeam("TeamA", Integer.MAX_VALUE, Integer.MAX_VALUE - 1), // Difference: 1
                new FootballTeam("TeamB", Integer.MAX_VALUE, Integer.MAX_VALUE - 2)  // Difference: 2
        );

        FootballAnalyzer analyzer = new FootballAnalyzer();
        String result = analyzer.analyze(records);
        assertEquals("TeamA", result, "Team with the smallest goal difference should be TeamA (large numbers)");
    }
}
