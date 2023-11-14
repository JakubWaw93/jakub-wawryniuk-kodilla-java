package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

@DisplayName("TDD: ShapeCollector Test Suit ")
public class ShapeCollectorTestSuit{

        private static int testCounter = 0;

        @BeforeAll
        public static void beforeAllTests(){
            System.out.println("This is the begining of tests.");
        }

        @AfterAll
        public static void afterAllTests(){
            System.out.println("All tests are finished");
        }

        @BeforeEach
        public void beforeEachTest() {
            testCounter++;
            System.out.println("Prepering to execute test #" + testCounter);
        }

        @Nested
        @DisplayName("Tests fo adding, removing and getting Obj from colletion")
        class ObjectTests {
            @Test
            @DisplayName("Test checking if after adding 1 object to list, list size is increasing by 1")
            void testAddFigure() {
                //Given
                Circle circle = new Circle(15);
                ShapeCollector collector = new ShapeCollector();
                collector.addFigure(circle);
                //When
                int result = collector.getSizeOfList();
                int expectedResult = 1;
                //Then
                Assertions.assertEquals(expectedResult, result);
            }

            @Test
            @DisplayName("Test checking if after removing 1 object from list, list size is decreasing by 1 ")
            void testRemoveFigure() {
                //Given
                Circle circle = new Circle(15);
                ShapeCollector collector = new ShapeCollector();
                collector.addFigure(circle);
                collector.removeFigure(circle);
                //When
                int result = collector.getSizeOfList();
                int expectedResult = 0;
                //Then
                Assertions.assertEquals(expectedResult, result);

            }

            @Test
            @DisplayName("Test checking if object pulled by getFigure() is the same that was putted there")
            void testGetFigure() {
                //Given
                Square square = new Square(8);
                ShapeCollector collector = new ShapeCollector();
                collector.addFigure(square);
                //When
                Shape result = collector.getFigure(0);
                Shape expectedResult = square;
                //Then
                Assertions.assertEquals(expectedResult, result);
            }
        }

    @Nested
    @DisplayName("Test for collection whole content")
    class CollectionTest {
        @Test
        @DisplayName("Test checking if listOfFigures inside collector is the same as it should be after adding 2 objects")
        void testShowFigures() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Square square = new Square(8);
            Circle circle = new Circle(15);
            Circle circle1 = new Circle(125);
            Circle circle2 = new Circle(12);
            collector.addFigure(square);
            collector.addFigure(circle);
            //When
            ArrayList<Shape> result = collector.showFigures();
            ArrayList<Shape> expectedResult = new ArrayList<>();
            expectedResult.add(square);
            expectedResult.add(circle);
            //Then
            Assertions.assertIterableEquals(result, expectedResult);

        }
    }
}
