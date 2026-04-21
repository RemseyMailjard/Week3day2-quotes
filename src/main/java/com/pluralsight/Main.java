package com.pluralsight;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        QuoteFileReader fileReader = new QuoteFileReader();
        List<Quote> quotes = fileReader.readQuotesFromCsv("quotes.csv");

        QuoteManager manager = new QuoteManager();

        for (Quote quote : quotes) {
            manager.addQuote(quote);
        }

        manager.printAllQuotes();
        System.out.println("\nTotal quotes: " + manager.getQuoteCount());
    }
}