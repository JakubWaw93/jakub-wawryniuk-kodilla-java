package com.kodilla.testing.library;

import java.util.Objects;

public class Book {

    String title;
    String auuthor;
    int publicationYear;

    public Book(String title, String auuthor, int publicationYear) {
        this.title = title;
        this.auuthor = auuthor;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuuthor() {
        return auuthor;
    }

    public void setAuuthor(String auuthor) {
        this.auuthor = auuthor;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear && Objects.equals(title, book.title) && Objects.equals(auuthor, book.auuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, auuthor, publicationYear);
    }
}
