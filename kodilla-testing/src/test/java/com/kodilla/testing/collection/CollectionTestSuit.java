package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")

public class CollectionTestSuit {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
        System.out.println();
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
        System.out.println();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
        System.out.println();
    }


    @DisplayName(
            "When applied on List with Odd and Even numbers, " +
            "then created list contains only Even numbers from first list "
    )
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumberExterminator exterminator = new OddNumberExterminator();
        List<Integer> normalList = new ArrayList<>();
        normalList.add(5);
        normalList.add(4);
        normalList.add(6);
        normalList.add(0);
        normalList.add(7);
        normalList.add(8);
        //When
        List<Integer> result = exterminator.exterminate(normalList);
        //Then
        /*List<Integer> evensFromNormalList = new ArrayList<>();
        evensFromNormalList.add(4);
        evensFromNormalList.add(6);
        evensFromNormalList.add(0);
        evensFromNormalList.add(8);*/
        List evensFromNormalList = Arrays.asList(4, 6, 0, 8);
        System.out.println("Testing normal List");
        Assertions.assertEquals(evensFromNormalList, result );
    }

    @DisplayName(
            "When applied on empty List, " +
                    "then created list is also empty"
    )
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumberExterminator exterminator = new OddNumberExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = exterminator.exterminate(emptyList);
        List<Integer> expectedResult = emptyList;
        System.out.println("Testing empty List");
        //Then
        Assertions.assertEquals(result, expectedResult);
    }


}
