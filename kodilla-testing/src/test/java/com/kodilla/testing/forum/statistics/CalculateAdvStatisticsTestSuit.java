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
        List<String> listNames = new ArrayList<>();

        when(statisticsMock.commentsCount()).thenReturn(advMockStatistics.get("numberOfComments"));
        when(statisticsMock.userNames()).thenReturn(listNames);
        when(statisticsMock.postCount()).thenReturn(advMockStatistics.get("numberOfPosts"));

        //when
        Map<String, Integer> advMockStatistics2 = statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertIterableEquals(advMockStatistics.values(),advMockStatistics2.values() );
    }

}
