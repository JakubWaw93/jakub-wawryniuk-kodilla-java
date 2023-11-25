package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            SecondChallenge secondChallenge = new SecondChallenge();
            secondChallenge.probablyIWillThrowException(2, 1);
        } catch (Exception e) {
            System.out.println("It wasn't joking, it really throws an exception.");
        } finally {
            System.out.println("One way or another, we got here");
        }
    }
}
