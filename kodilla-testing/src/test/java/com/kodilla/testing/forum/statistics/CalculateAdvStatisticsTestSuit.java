package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.statistic.Statistics;
import com.kodilla.testing.statistic.StatisticsCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateAdvStatisticsTestSuit {

    @Mock
    private Statistics statisticsMock;

    public Map<String, Integer> generateMapOfStatistics(int numberOfUsers, int numberOfPosts, int numberOfComments) {
        Map<String, Integer> advMockStatistics = new HashMap<>();

        advMockStatistics.put("numberOfUsers", numberOfUsers);
        advMockStatistics.put("numberOfPosts", numberOfPosts);
        advMockStatistics.put("numberOfComments", numberOfComments);

        if(numberOfUsers>0) {
            int averagePostsForUser = numberOfPosts / numberOfUsers;
            int averageCommentsForUser = numberOfComments / numberOfUsers;
            advMockStatistics.put("averagePostsForUser", averagePostsForUser);
            advMockStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }else{
            int averagePostsForUser = 0;
            int averageCommentsForUser = 0;
            advMockStatistics.put("averagePostsForUser", averagePostsForUser);
            advMockStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }
        if(numberOfPosts>0) {
            int averageCommentsForPost = numberOfComments / numberOfPosts;
            advMockStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }else{
            int averageCommentsForPost = 0;
            advMockStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }

        return advMockStatistics;
    }


    @Test
    void testCalculateAdvStatisticsPost0() {
        //Given
        StatisticsCalculator statisticsCalculator =  new StatisticsCalculator(statisticsMock);
        Map <String, Integer> advMockStatistics = generateMapOfStatistics(0, 0, 0);
        //int expectedAveragePostsPerUser = advMockStatistics.get("averagePostsForUser");
        //int expectedAverageCommentsForUser = advMockStatistics.get("averageCommentsForUser");
        //int expectedAverageCommentsForPost = advMockStatistics.get("averageCommentsForPost");

        when(statisticsCalculator.calculateAdvStatistics(statisticsMock)).thenReturn(generateMapOfStatistics(0,0,0));


        //when(statisticsMock.userNames()).thenReturn();
        //when(statisticsMock.commentsCount()).thenReturn(0);
        //when(statisticsMock.postCount()).thenReturn(0);

        //when
        Map<String, Integer> advMockStatistics2 = statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //int averagePostsPerUser = statisticsCalculator.calculateAdvStatistics(statisticsMock).get("averagePostsForUser");
        //int averageCommentsPerUser = statisticsCalculator.calculateAdvStatistics(statisticsMock).get("averageCommentsForUser");
        //int averageCommentsPerPost = statisticsCalculator.calculateAdvStatistics(statisticsMock).get("averageCommentsForPost");
        //Then
        //Assertions.assertEquals(expectedAveragePostsPerUser, averagePostsPerUser);
        //Assertions.assertEquals(expectedAverageCommentsForUser, averageCommentsPerUser);
        //Assertions.assertEquals(expectedAverageCommentsForPost, averageCommentsPerPost);
        Assertions.assertIterableEquals(advMockStatistics.values(),advMockStatistics2.values() );
    }

}
