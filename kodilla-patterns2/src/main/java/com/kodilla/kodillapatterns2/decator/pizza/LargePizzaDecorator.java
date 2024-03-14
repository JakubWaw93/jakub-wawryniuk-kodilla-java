package com.kodilla.kodillapatterns2.decator.pizza;

import java.math.BigDecimal;

public class LargePizzaDecorator extends AbstractPizzaOrderDecorator {

    protected LargePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + large";
    }
}
