package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class WorldTestSuit {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Continent asia = new Continent("Asia",new ArrayList<>());
        asia.addCountry(new Country("China", new BigDecimal(1412000000)));
        asia.addCountry(new Country("India", new BigDecimal(1408000000)));
        asia.addCountry(new Country("Japan", new BigDecimal(125700000)));
        Continent europe = new Continent("Europe",new ArrayList<>());
        europe.addCountry(new Country("France", new BigDecimal(67750000)));
        europe.addCountry(new Country("Germany", new BigDecimal(83200000)));
        europe.addCountry(new Country("France", new BigDecimal(37750000)));
        Continent africa = new Continent("Africa",new ArrayList<>());
        africa.addCountry(new Country("Egypt", new BigDecimal(109300000)));
        africa.addCountry(new Country("Liban", new BigDecimal(5593000)));
        africa.addCountry(new Country("Sudan", new BigDecimal(45660000)));
        Continent northAmerica = new Continent("North America",new ArrayList<>());
        northAmerica.addCountry(new Country("USA", new BigDecimal(331900000)));
        Continent southAmerica = new Continent("South America", new ArrayList<>());
        southAmerica.addCountry(new Country("Brazil", new BigDecimal(214300000)));
        World world = new World(new ArrayList<>());
        world.addContinent(asia);
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);

        //When
        BigDecimal worldPeopleQuantity = world.getPeopleQuantity();

        //Then
        //asia population =2945700000
        //europe population = 188700000
        //africa population = 160553000
        //north america population = 331900000
        //south america population = 214300000
        //world population = 3841153000
        BigDecimal expectedWorldPeopleQuantity = new BigDecimal("3841153000");
        Assertions.assertEquals(expectedWorldPeopleQuantity, worldPeopleQuantity);




    }
}
