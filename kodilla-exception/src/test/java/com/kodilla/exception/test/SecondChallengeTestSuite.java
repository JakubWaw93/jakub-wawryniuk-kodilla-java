package com.kodilla.exception.test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SecondChallengeTestSuite {

    @Test
    void noExceptionTest(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertDoesNotThrow(()->secondChallenge.probablyIWillThrowException(1,5));
    }

    @Test
    void exceptionsTests(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertAll(
                ()->assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(2,5)),
                ()->assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(0,5)),
                ()->assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(1,1.5)),
                ()->assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(2,1.5))
        );
    }

}
