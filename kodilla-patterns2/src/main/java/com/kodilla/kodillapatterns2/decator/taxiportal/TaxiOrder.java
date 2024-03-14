package com.kodilla.kodillapatterns2.decator.taxiportal;

import java.math.BigDecimal;

public interface TaxiOrder {

    BigDecimal getCost();
    String getDescription();

}
