package com.kodilla.patterns.strategy.social;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User jack = new Millenials("Jack Black");
        User ivone = new YGeneration("Ivone Gray");
        User andrew = new ZGeneration("And Rew");
        //When
        String jackShares = jack.sharePost();
        String ivoneShares = ivone.sharePost();
        String andrewShares = andrew.sharePost();
        //Then
        assertEquals("Facebook", jackShares);
        assertEquals("Twitter", ivoneShares);
        assertEquals("Snapchat", andrewShares);
    }

    @Test
    void testIndividualSharingStrategies() {
        //Given
        User jack = new Millenials("Jack Black");
        //When
        jack.SetSocialPublisher(new SnapchatPublisher());
        //Then
        assertEquals("Snapchat", jack.sharePost());
    }
}
