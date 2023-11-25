package com.kodilla.exception.test;

import java.util.List;

public class RouteNotFoundExceptionHandler {
    public static void main(String[] args) {
        try {
            FlightFinder flightFinder = new FlightFinder();
            Flight flight = new Flight("Warsaw Chopin Airport", "Tokyo International Airport");

            String availableFlight = flightFinder.findFlight(flight);
            System.out.println(availableFlight);
        } catch (RouteNotFoundException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank You for choosing our services");
            System.out.println();
        }

        try {
            FlightFinder flightFinder = new FlightFinder();
            Flight flight = new Flight("Tokyo International Airport", "Warsaw Chopin Airport");

            String availableFlight = flightFinder.findFlight(flight);
            System.out.println(availableFlight);
        } catch (RouteNotFoundException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank You for choosing our services");
            System.out.println();
        }

        try {
            FlightFinder flightFinder = new FlightFinder();
            Flight flight = new Flight("Warsaw Chopin Airport", "John F. Kennedy International Airport");

            String availableFlight = flightFinder.findFlight(flight);
            System.out.println(availableFlight);
        } catch (RouteNotFoundException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank You for choosing our services");
            System.out.println();
        }


    }
}
