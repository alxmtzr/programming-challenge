package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.data.model.FootballTeam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FootballCsvParserTest {

    @Test
    public void testParseValidLine() {
        // arrange
        String line = "Arsenal,38,26,9,3,79,36,87";
        FootballCsvParser parser = new FootballCsvParser();
        FootballTeam result = parser.parse(line);

        assertEquals("Arsenal", result.team());
        assertEquals(79, result.goals());
        assertEquals(36, result.goalsAgainst());
    }

    @Test
    public void testInvalidCsvLine() {
        String line = "Arsenal,38,26,9,3,invalid,36,87"; // invalid value
        FootballCsvParser parser = new FootballCsvParser();

        FootballTeam result = parser.parse(line);
        assertNull(result, "Invalid line should return null");
    }
}
