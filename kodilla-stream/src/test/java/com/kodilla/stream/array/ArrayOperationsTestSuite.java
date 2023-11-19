package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite implements ArrayOperations {

    @Test
    void testGetAverage() {
        //Given
        int[] testArray = {12, 64, 5, 26, 7, 78, 8};

        //When
        double average = ArrayOperations.getAverage(testArray);

        //Then
        double expectedAverage = 28.57;
        Assertions.assertEquals(expectedAverage,average,0.01);


    }
}
