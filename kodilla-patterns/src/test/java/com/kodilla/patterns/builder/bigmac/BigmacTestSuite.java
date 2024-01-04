package com.kodilla.patterns.builder.bigmac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBuildingBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredients(Ingredient.CHILI_PEPPERS)
                .bun(Bun.BUN_WITH_SESAME)
                .burgers(Burgers.DOUBLE)
                .sauce(Sauce.THOUSAND_ISLANDS)
                .ingredients(Ingredient.CHEESE)
                .ingredients(Ingredient.BACON)
                .ingredients(Ingredient.ONION)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        Burgers howManyBurgers = bigmac.getBurgers();
        Sauce whatSauce = bigmac.getSauce();
        //Then
        assertEquals(4, howManyIngredients);
        assertEquals(Burgers.DOUBLE, howManyBurgers);
        assertEquals(Sauce.THOUSAND_ISLANDS, whatSauce);

    }
}
