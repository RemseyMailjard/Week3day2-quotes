package com.pluralsight;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads Quote data from a CSV file in the resources folder.
 *
 * "Separation of Concerns:
 * This class is only responsible for reading quote data."
 */
public class QuoteFileReader {

    public List<Quote> readQuotesFromCsv(String fileName) {
        List<Quote> quotes = new ArrayList<>();

        // "Read the file from the classpath (resources folder)"
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            // "Skip the header row"
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // "Basic validation: make sure the row has 4 columns"
                if (parts.length != 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                String text = removeQuotes(parts[0]);
                String author = removeQuotes(parts[1]);
                String category = removeQuotes(parts[2]);
                int year = Integer.parseInt(parts[3].trim());

                Quote quote = new Quote(text, author, category, year);
                quotes.add(quote);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV: " + e.getMessage());
        }

        return quotes;
    }

    /**
     * Removes surrounding double quotes from CSV values.
     */
    private String removeQuotes(String value) {
        return value.replace("\"", "").trim();
    }
}