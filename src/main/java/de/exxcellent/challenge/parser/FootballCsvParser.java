package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.data.model.FootballTeam;

/**
 * Parses a line of a CSV file into a {@link FootballTeam}..
 */
public class FootballCsvParser implements CsvParser<FootballTeam> {
    @Override
    public FootballTeam parse(String line) {
        final String[] parts = line.split(",");
        if (parts.length <= 7) { // check if the line has at least 7 columns
            return null; // ignore invalid line
        }

        try {
            final String teamName = parts[0].trim();
            final int goals = Integer.parseInt(parts[5].trim());
            final int goalsAgainst = Integer.parseInt(parts[6].trim());
            return new FootballTeam(teamName, goals, goalsAgainst);
        } catch (NumberFormatException e) {
            return null; // ignore invalid line
        }
    }
}
