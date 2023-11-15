package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();


    public ForumUser(final String username,final String realName, final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public void addFriend(ForumUser user){
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user){
        return friends.remove(user);
    }

    public Set<String> getLocationsOfFriends(){
        return friends.stream()
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
    public Set<String> getLocationsOfFriendsOfFriends(){
        return friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter((user -> user != this))
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }


    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ForumUser{");
        sb.append("username='").append(username).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        return Objects.equals(username, forumUser.username);
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
