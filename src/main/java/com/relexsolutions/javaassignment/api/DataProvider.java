package com.relexsolutions.javaassignment.api;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class DataProvider {

    public static List<Entry> getEntriesForPart1() {
        return getEntries("src/main/resources/part1.csv");
    }

    public static List<Entry> getEntriesForPart2() {
        return getEntries("src/main/resources/part2.csv");
    }

    public static List<Entry> getEntriesForPart3() {
        return getEntries("src/main/resources/part3.csv");
    }

    public static List<Forecast> getForecasts() {
        List<Forecast> forecasts = new ArrayList<>();

        try (
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/forecasts.csv"), '|', '"')) {
            reader.readNext(); // Read header
            reader.forEach(row -> {
                LocalDate date = LocalDate.parse(row[2]);
                double quantity = Double.parseDouble(row[1]);
                Forecast forecast = new Forecast(row[0], date, quantity);
                forecasts.add(forecast);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forecasts;
    }

    private static List<Entry> getEntries(String file) {
        List<Entry> entries = new ArrayList<>();

        try (
            CSVReader reader = new CSVReader(new FileReader(file), '|', '"')) {
            reader.readNext(); // Read header
            reader.forEach(row -> {
                LocalDate startDate = row[2].isEmpty() ? null : LocalDate.parse(row[2]);
                LocalDate endDate = row[3].isEmpty() ? null : LocalDate.parse(row[3]);
                double multiplier = row[4].isEmpty() ? 1.0 : Double.parseDouble(row[4]);
                Entry entry = new Entry(row[0], row[1], multiplier, startDate, endDate);
                entries.add(entry);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entries;
    }
}
