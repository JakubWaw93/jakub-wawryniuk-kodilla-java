package kodilla.com.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightsBoard {

    private final List <Flight> listOfFlights;

    public FlightsBoard() {
        listOfFlights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        listOfFlights.add(flight);
    }

    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }
}
