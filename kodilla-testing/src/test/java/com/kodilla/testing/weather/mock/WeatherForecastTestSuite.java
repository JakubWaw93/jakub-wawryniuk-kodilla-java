package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void beforeEachTest() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        testCounter++;
        System.out.println("Prepering to execute test #" + testCounter);
    }

    @AfterEach
    void  afterEach(){
        System.out.println();
    }

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the begining of tests.");
        System.out.println();
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }

    @Test
    @DisplayName("Test for quantity of data")
    void testCalculateForecastWithMock() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    @DisplayName("Test for average from data")
    void testCalculateAverageWithMock(){

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double average = weatherForecast.calculateAverageTemp();
        double expectedAverage = 25.56;

        //Then
        Assertions.assertEquals(expectedAverage, average);
    }

    @Test
    @DisplayName("Test for median from data")
    void testCalculateMedianWithMMock(){

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double median = weatherForecast.calculateMedian();
        double expectedMedian = 25.5;

        //Then
        Assertions.assertEquals(expectedMedian, median);
    }
}