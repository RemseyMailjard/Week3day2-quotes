package com.pluralsight;

public class Quote {

    private String text;
    private String author;
    private String category;
    private int year;

    public Quote() {
    }

    public Quote(String text, String author, String category, int year) {
        setText(text);
        setAuthor(author);
        setCategory(category);
        setYear(year);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        validateText(text);
        this.text = text.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        validateAuthor(author);
        this.author = author.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        validateCategory(category);
        this.category = category.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    @Override
    public String toString() {
        return "\"" + text + "\"\n- " + author + " (" + category + ", " + year + ")";
    }

    private void validateText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Quote text cannot be empty.");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().length() < 2) {
            throw new IllegalArgumentException("Author name is too short.");
        }
    }

    private void validateCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }
    }

    private void validateYear(int year) {
        if (year < 0 || year > 2100) {
            throw new IllegalArgumentException("Year is not valid.");
        }
    }
}