package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum(){
        forumUsers.add(new ForumUser(1,"user1",'F', LocalDate.of(1997,12,5),112));
        forumUsers.add(new ForumUser(2,"user2",'F', LocalDate.of(1960,6,8),19));
        forumUsers.add(new ForumUser(3,"user3",'F', LocalDate.of(2011,12,11),23));
        forumUsers.add(new ForumUser(4,"user4",'F', LocalDate.of(1976,5,12),159));
        forumUsers.add(new ForumUser(5,"user5",'M', LocalDate.of(2005,11,16),5));
        forumUsers.add(new ForumUser(6,"user6",'F', LocalDate.of(1988,8,18),0));
        forumUsers.add(new ForumUser(7,"user7",'F', LocalDate.of(2000,3,22),1));
        forumUsers.add(new ForumUser(8,"user8",'M', LocalDate.of(1997,11,26),6));
        forumUsers.add(new ForumUser(9,"user9",'M', LocalDate.of(1990,6,29),56));
        forumUsers.add(new ForumUser(10,"user10",'M', LocalDate.of(1970,2,12),454));
        forumUsers.add(new ForumUser(11,"user11",'M', LocalDate.of(1999,2,5),20));
        forumUsers.add(new ForumUser(12,"user12",'M', LocalDate.of(1992,5,1),0));
        forumUsers.add(new ForumUser(13,"user13",'M', LocalDate.of(1985,1,2),6));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(forumUsers);
    }
}
