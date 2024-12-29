package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.data.model.WeatherRecord;

import java.util.List;

public class WeatherAnalyzer implements Analyzer<WeatherRecord, Integer> {

    @Override
    public Integer analyze(List<WeatherRecord> records) {
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("Records must not be null or empty");
        }

        return records.stream()
                .min((record1, record2) -> {
                    int spread1 = record1.maxTemp() - record1.minTemp();
                    int spread2 = record2.maxTemp() - record2.minTemp();
                    return Integer.compare(spread1, spread2);
                })
                .map(WeatherRecord::dayOfMonth)
                .orElseThrow(() -> new IllegalArgumentException("No minimum spread found"));
    }
}
