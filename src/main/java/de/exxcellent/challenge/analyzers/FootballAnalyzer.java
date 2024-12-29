package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.data.model.FootballTeam;

import java.util.List;

/**
 * Analyzes a list of {@link FootballTeam}s and returns the team with the smallest difference between
 * goals scored and goals conceded.
 */
public class FootballAnalyzer implements Analyzer<FootballTeam, String> {

    @Override
    public String analyze(List<FootballTeam> records) {
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("Records must not be null or empty");
        }

        return records.stream()
                .min((record1, record2) -> {
                    int difference1 = calculateDifference(record1);
                    int difference2 = calculateDifference(record2);
                    return Integer.compare(difference1, difference2);
                })
                .map(FootballTeam::team)
                .orElseThrow(() -> new IllegalArgumentException("No minimum difference found"));
    }

    private int calculateDifference(FootballTeam team) {
        if (team.goals() < 0 || team.goalsAgainst() < 0) {
            throw new IllegalArgumentException("Goals and goals allowed must be non-negative");
        }
        return Math.abs(team.goals() - team.goalsAgainst());
    }

}
