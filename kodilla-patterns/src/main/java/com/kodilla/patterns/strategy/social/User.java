package com.kodilla.patterns.strategy.social;

public sealed class User
        permits Millenials, ZGeneration, YGeneration {

    private String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void SetSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
