package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class LibraryTestSuite {

    @Test
    void testGetsBooks() {
        //Given
        Library library = new Library("Warsaw Public Library");
        library.getBooks().add(new Book("King Rat", "James Clavell", LocalDate.of(1962, 1, 1)));
        library.getBooks().add(new Book("Shogun", "James Clavell", LocalDate.of(1975, 1, 1)));
        library.getBooks().add(new Book("Hard to Be a God", "Arkady and Boris Strugatsky", LocalDate.of(1964, 1, 1)));

        System.out.println(library.getBooks());

        //shallowClone
        Library libraryClone = null;
        try {
            libraryClone = library.shallowCopy();
            libraryClone.setName("Warsaw Private Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(libraryClone);
        //deepClone
        Library libraryDeepClone = null;
        try {
            libraryDeepClone = library.deepCopy();
            libraryClone.setName("Warsaw Private Library no. 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(libraryDeepClone);
        //operation on deep clone
        //When
        libraryDeepClone.getBooks().clear();
        //Then
        assertEquals(3, library.getBooks().size());
        assertEquals(0, libraryDeepClone.getBooks().size());
        //operation on shallow clone
        //When
        libraryClone.getBooks().clear();
        //Then
        assertEquals(0, library.getBooks().size());
        assertEquals(0, libraryClone.getBooks().size());
    }

}
