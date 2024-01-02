package kodilla.com.good.patterns.challenges.flights;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class FlightsTestSuite {

    Service service = new Service();
    static FlightsBoard flightsBoard = new FlightsBoard();
    List<Flight> listOfAllFLights = flightsBoard.getListOfFlights();
    @BeforeAll
    static void addFlights(){
        flightsBoard.addFlight(new Flight("London", "Ankara", "Warsaw", LocalDateTime.of(2024, 1, 2, 16, 0)));
        flightsBoard.addFlight(new Flight("Berlin", "Tokyo", "Egypt", LocalDateTime.of(2024, 1, 2, 21, 0)));
        flightsBoard.addFlight(new Flight("London", "Ankara", "Berlin", LocalDateTime.of(2024, 1, 3, 16, 0)));

    }

    @Test
    void testSearchFrom() {
        //Given
        //When&Then
        List<Flight> listFrom = service.findFlightFrom(listOfAllFLights, "London");
        listFrom.stream()
                .forEach(System.out::println);
    }

    @Test
    void testSearchTo() {
        //Given
        //When&Then
        List<Flight> listTo = service.findFlightTo(listOfAllFLights, "Tokyo");
        listTo.stream()
                .forEach(System.out::println);
    }


    @Test
    void testSearchVia() {
        //Given
        //When&Then
        List<Flight> listVia = service.findFlightVia(listOfAllFLights, "London", "Ankara", "Berlin");
        listVia.stream()
                .forEach(System.out::println);
    }



}
