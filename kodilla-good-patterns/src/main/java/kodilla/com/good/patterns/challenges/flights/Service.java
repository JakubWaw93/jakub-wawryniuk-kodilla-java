package kodilla.com.good.patterns.challenges.flights;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Service {

    private FlightsBoard flightsBoard;

    public List<Flight> findFlightFrom(List<Flight> listOfFLights, String cityFrom) {
        return listOfFLights.stream()
                .filter(flight -> Objects.equals(flight.getFrom(), cityFrom))
                .toList();
    }

    public List<Flight> findFlightTo(List<Flight> listOfFLights, String cityTo) {
        return listOfFLights.stream()
                .filter(flight -> Objects.equals(flight.getTo(), cityTo))
                .toList();
    }

    public List<Flight> findFlightVia(List<Flight> listOfFLights, String cityFrom, String cityTo, String cityVia) {
        return listOfFLights.stream()
                .filter(flight -> Objects.equals(flight.getFrom(), cityFrom))
                .filter(flight -> Objects.equals(flight.getTo(), cityTo))
                .filter(flight -> Objects.equals(flight.getVia(), cityVia))
                .toList();
    }



}
