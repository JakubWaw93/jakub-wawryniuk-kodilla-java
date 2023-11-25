package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinder {

    public String findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw Chopin Airport", false);
        airports.put("Tokyo International Airport", true);

        String availableFlight="";
        for (Map.Entry<String, Boolean> entry : airports.entrySet()) {
            if (entry.getKey().equals(flight.getArrivalAirport()) && entry.getValue()) {
                availableFlight=entry.getKey();
            }
        }
        if (airports.containsKey(flight.getArrivalAirport())) {
            if (availableFlight.isEmpty()) {
                return "Selected destination is not available right now.";
            } else {
                return availableFlight;
            }
        } else {
            throw new RouteNotFoundException("This carrier does not offer flights to the selected destination");
        }
    }


}
