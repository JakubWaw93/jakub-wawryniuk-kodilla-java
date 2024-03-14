package com.kodilla.kodillapatterns2.decator.pizza;

import com.kodilla.kodillapatterns2.decator.taxiportal.AbstractTaxiOrderDecorator;

import java.math.BigDecimal;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {

    private final PizzaOrder pizzaOrder;
    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
