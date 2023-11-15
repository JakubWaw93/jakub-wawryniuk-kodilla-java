package com.kodilla.stream.sand;

import java.math.BigDecimal;

public class Europe implements SandStorage{

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("22222222222222222222");
        return sandQuantity;
    }
}
