package com.kodilla.kodillapatterns2.decator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(20);
    }

    @Override
    public String getDescription() {
        return "Pizza order";
    }
}
