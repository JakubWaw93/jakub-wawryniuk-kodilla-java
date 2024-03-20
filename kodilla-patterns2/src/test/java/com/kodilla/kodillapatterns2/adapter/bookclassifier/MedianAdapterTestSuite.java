package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.kodillapatterns2.adapter.bookclassifier.libraryb.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclassifier.libraryb.Statistics;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book(
                "Autor1",
                "Tytuł1",
                2000,
                "sygnatura1"
        ));
        books.add(new Book(
                "Autor2",
                "Tytuł2",
                2006,
                "sygnatura2"
        ));
        books.add(new Book(
                "Autor3",
                "Tytuł3",
                1964,
                "sygnatura3"
        ));
        Statistics statistics = new Statistics();
        MedianAdapter medianAdapter = new MedianAdapter(statistics);
        //When
        int result = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(2000, result);
    }
}
