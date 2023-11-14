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



    public Map<String, Integer> calculateAdvStatistics(Statistics statistics) {
        Map<String, Integer> advStatistics = new HashMap<>();
        numberOfUsers = statistics.userNames().size();
        advStatistics.put("numberOfUsers", numberOfUsers);
        numberOfPosts = statistics.postCount();
        advStatistics.put("numberOfPosts", numberOfPosts);
        numberOfComments = statistics.commentsCount();
        advStatistics.put("numberOfComments", numberOfComments);
        if(numberOfUsers>0) {
            averagePostsForUser = numberOfPosts / numberOfUsers;
            averageCommentsForUser = numberOfComments / numberOfUsers;
            advStatistics.put("averagePostForUser", averagePostsForUser);
            advStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }else{
            System.out.println("There are no users here.");
            averagePostsForUser = 0;
            averageCommentsForUser = 0;
            advStatistics.put("averagePostForUser", averagePostsForUser);
            advStatistics.put("averageCommentsForUser", averageCommentsForUser);
        }
        if(numberOfPosts>0) {
            averageCommentsForPost = numberOfComments / numberOfPosts;
            advStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }else{
            System.out.println("There are no posts here.");
            averageCommentsForPost = 0;
            advStatistics.put("averageCommentsForPost", averageCommentsForPost);
        }
        if(numberOfComments<=0){
            System.out.println("There are no comments here.");
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