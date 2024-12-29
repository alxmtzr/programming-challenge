package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.data.model.FootballTeam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FootballCsvParserTest {

    @Test
    public void testParseValidLine() {
        // arrange
        String line = "TeamA,30,10";
        FootballCsvParser parser = new FootballCsvParser();
        FootballTeam result = parser.parse(line);

        assertEquals("TeamA", result.team());
        assertEquals(30, result.goals());
        assertEquals(10, result.goalsAgainst());
    }

    @Test
    public void testInvalidCsvLine() {
        String line = "TeamA,30,invalid"; // invalid value
        FootballCsvParser parser = new FootballCsvParser();

        FootballTeam result = parser.parse(line);
        assertNull(result, "Invalid line should return null");
    }
}
