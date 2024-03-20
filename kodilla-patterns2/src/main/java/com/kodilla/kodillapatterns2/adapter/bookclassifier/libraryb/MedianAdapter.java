package com.kodilla.kodillapatterns2.adapter.bookclassifier.libraryb;

import com.kodilla.kodillapatterns2.adapter.bookclassifier.MedianAdaptee;
import com.kodilla.kodillapatterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.kodillapatterns2.adapter.bookclassifier.librarya.Classifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    public MedianAdapter(Statistics statistics) {
        super(statistics);
    }

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.kodillapatterns2.adapter.bookclassifier.libraryb.Book> books = new HashMap<>();
        for (Book book : bookSet) {
            books.put(new BookSignature(book.getSignature()),
                    new com.kodilla.kodillapatterns2.adapter.bookclassifier.libraryb.Book(book.getAuthor()
                            , book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(books);
    }
}
