package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/**
 * QuoteManager is responsible for managing a collection of Quote objects.
 *
 * "Single Responsibility Principle (SRP):
 * This class only manages quotes (add, retrieve, count, display)."
 *
 * "High Cohesion:
 * All methods are directly related to managing quotes."
 */
public class QuoteManager {

    // "Program to an interface (List) instead of a concrete class (ArrayList) → Loose Coupling"
    private final List<Quote> quotes;

    /**
     * Constructor initializes the internal list.
     *
     * "Keep it simple (KISS): straightforward initialization."
     */
    public QuoteManager() {
        this.quotes = new ArrayList<>();
    }

    /**
     * Adds a new quote to the collection.
     *
     * "Encapsulation: control how data enters the class."
     * "Defensive programming: prevent invalid (null) input."
     */
    public void addQuote(Quote quote) {
        if (quote == null) {
            throw new IllegalArgumentException("Quote cannot be null.");
        }
        quotes.add(quote);
    }

    /**
     * Returns all quotes.
     *
     * "Encapsulation: return a copy instead of the internal list."
     * "Prevents external code from modifying internal state."
     * "Supports Loose Coupling."
     */
    public List<Quote> getAllQuotes() {
        return new ArrayList<>(quotes); // protects internal list
    }

    /**
     * Prints all quotes to the console.
     *
     * "Separation of Concerns:
     * In larger systems, printing should be handled by a separate class (e.g., UI or formatter)."
     *
     * "KISS: simple loop for clarity."
     */
    public void printAllQuotes() {
        for (Quote quote : quotes) {
            System.out.println(quote);
        }
    }

    /**
     * Returns the number of stored quotes.
     *
     * "Utility method: improves readability and reuse."
     */
    public int getQuoteCount() {
        return quotes.size();
    }
}