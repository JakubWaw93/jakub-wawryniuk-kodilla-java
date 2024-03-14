package com.kodilla.kodillapatterns2.decator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), cost);
    }

    @Test
    void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Pizza order", description);
    }

    @Test
    void testPepperoniLargePizzaExtraCheeseGetCost() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new PepperoniPizzaDecorator(order);
        order = new LargePizzaDecorator(order);
        order = new ExtraCheeseDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(55), cost);
    }

    @Test
    void testPepperoniLargePizzaExtraCheeseGetDescription() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new PepperoniPizzaDecorator(order);
        order = new LargePizzaDecorator(order);
        order = new ExtraCheeseDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Pepperoni/ Pizza order + large + extra cheese", description);
    }
}
