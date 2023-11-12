package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.statistic.Statistics;
import com.kodilla.testing.statistic.StatisticsCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateAdvStatisticsTestSuit {

    @Mock
    private Statistics statisticsMock;

    private static int counter = 0;


    @BeforeEach
    public void before(){
        counter++;
        System.out.println("Test Case #"+counter+": begin");
    }
    @AfterEach
    public void after() {
        System.out.println("Test Case #"+counter+": end");
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


    private Map<String, Integer> generateMapOfStatistics(int numberOfUsers, int numberOfPosts, int numberOfComments) {
        Map<String, Integer> advMockStatistics = new HashMap<>();

        advMockStatistics.put("numberOfUsers", numberOfUsers);
        advMockStatistics.put("numberOfPosts", numberOfPosts);
        advMockStatistics.put("numberOfComments", numberOfComments);

        if (numberOfUsers > 0) {
            int averagePostsForUser = numberOfPosts / numberOfUsers;
            int averageCommentsForUser = numberOfComments / numberOfUsers;
            advMockStatistics.put("averagePostsForUser", averagePostsForUser);
            advMockStatistics.put("averageCommentsForUser", averageCommentsForUser);
        } else {
            int averagePostsForUser = 0;
            int averageCommentsForUser = 0;
            advMockStatistics.put("averagePostsForUser", averagePostsForUser);
            advMockStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }
        if (numberOfPosts > 0) {
            int averageCommentsForPost = numberOfComments / numberOfPosts;
            advMockStatistics.put("averageCommentsForPost", averageCommentsForPost);
        } else {
            int averageCommentsForPost = 0;
            advMockStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }

        return advMockStatistics;
    }

    private List<String> generateListOfNames(int n) {
        List<String> listOfNames = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listOfNames.add("Name" + n);
        }
        return listOfNames;
    }

    @Test
    void testCalculateAdvStatistics0Posts() {
        //Given
        StatisticsCalculator statisticsCalculator =  new StatisticsCalculator(statisticsMock);
        Map <String, Integer> expAdvMockStatistics = generateMapOfStatistics(1, 0, 0);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //when
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(),advMockStatistics.values());

    }

    @Test
    void testCalculateAdvStatistics1000Posts(){
        //Given
        StatisticsCalculator statisticsCalculator =  new StatisticsCalculator(statisticsMock);
        Map <String, Integer> expAdvMockStatistics = generateMapOfStatistics(1, 1000, 1000);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //When
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(),advMockStatistics.values());
    }

    @Test
    void testCalculateAdvStatistics0Comments(){
        //Given
        StatisticsCalculator statisticsCalculator =  new StatisticsCalculator(statisticsMock);
        Map <String, Integer> expAdvMockStatistics = generateMapOfStatistics(1, 1000, 0);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //When
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(),advMockStatistics.values());

    }

    @Test
    void testCalculateAdvStatisticsCommentsLessThanPosts(){
        //Given
        StatisticsCalculator statisticsCalculator =  new StatisticsCalculator(statisticsMock);
        Map <String, Integer> expAdvMockStatistics = generateMapOfStatistics(1, 1000, 500);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //When
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(),advMockStatistics.values());
    }

    @Test
    void testCalculateAdvStatisticsCommentsMoreThanPosts () {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        Map<String, Integer> expAdvMockStatistics = generateMapOfStatistics(1, 1000, 5000);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //When
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(), advMockStatistics.values());
    }

    @Test
    void testCalculateAdvStatistics0Users () {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        Map<String, Integer> expAdvMockStatistics = generateMapOfStatistics(0, 1000, 5000);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //When
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(), advMockStatistics.values());
    }

    @Test
    void testCalculateAdvStatistics100Users () {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        Map<String, Integer> expAdvMockStatistics = generateMapOfStatistics(100, 1000, 5000);
        List<String> listOfNames = generateListOfNames(expAdvMockStatistics.get("numberOfUsers"));

        when(statisticsMock.commentsCount()).thenReturn(expAdvMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listOfNames);
        when(statisticsMock.postCount()).thenReturn(expAdvMockStatistics.get("numberOfPosts"));

        //When
        Map<String, Integer> advMockStatistics = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(expAdvMockStatistics.values(), advMockStatistics.values());
    }

}
