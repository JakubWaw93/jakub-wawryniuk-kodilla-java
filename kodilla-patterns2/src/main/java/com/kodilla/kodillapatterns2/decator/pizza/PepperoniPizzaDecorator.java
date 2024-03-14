package com.kodilla.kodillapatterns2.decator.pizza;

import java.math.BigDecimal;

public class PepperoniPizzaDecorator extends AbstractPizzaOrderDecorator {

    protected PepperoniPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDescription() {
        return "Pepperoni/ " + super.getDescription();
    }
}
