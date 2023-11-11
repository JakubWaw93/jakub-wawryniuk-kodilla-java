package com.kodilla.testing.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator {

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private int averagePostsForUser;
    private int averageCommentsForUser;
    private int averageCommentsForPost;

    private Statistics statistics;


    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public List<String> userNames(){
        List<String> namesList = statistics.userNames();
        return namesList;
    }
    public int commentsCount(){
        int commentsCount = statistics.commentsCount();
        return commentsCount;
    }


    public Map<String, Integer> calculateAdvStatistics(Statistics statistics) {
        Map<String, Integer> advStatistics = new HashMap<>();
        numberOfUsers = userNames().size();
        //numberOfUsers = 52;
        advStatistics.put("numberOfUsers", numberOfUsers);
        numberOfPosts = statistics.postCount();
        //numberOfPosts = 421;
        advStatistics.put("numberOfPosts", numberOfPosts);
        numberOfComments = statistics.commentsCount();
        //numberOfComments = 6754;
        advStatistics.put("numberOfComments", numberOfComments);
        if(numberOfUsers>0) {
            averagePostsForUser = numberOfPosts / numberOfUsers;
            averageCommentsForUser = numberOfComments / numberOfUsers;
            advStatistics.put("averagePostForUser", averagePostsForUser);
            advStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }else{
            averagePostsForUser = 0;
            averageCommentsForUser = 0;
            advStatistics.put("averagePostForUser", averagePostsForUser);
            advStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }
        if(numberOfPosts>0) {
            averageCommentsForPost = numberOfComments / numberOfPosts;
            advStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }else{
            averageCommentsForPost = 0;
            advStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }

        return advStatistics;
    }



    public void showStatistic(){
        Map<String, Integer> statisticsMap = calculateAdvStatistics(statistics);
        for(Map.Entry<String, Integer> em : statisticsMap.entrySet()){
            System.out.println(em.getKey() + ": " + em.getValue());
        }

    }
}