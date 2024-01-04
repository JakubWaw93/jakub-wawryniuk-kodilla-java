package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final Bun bun;
    private final Burgers burgers;
    private final Sauce sauce;
    private List<Ingredient> ingredients = new ArrayList<>();

    public static class BigmacBuilder {

        private Bun bun;
        private Burgers burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(Burgers burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce =sauce;
            return this;
        }

        public BigmacBuilder ingredients(Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build(){
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public Bigmac(final Bun bun,final Burgers burgers,final Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bigmac{");
        sb.append("bun=").append(bun);
        sb.append(", burgers=").append(burgers);
        sb.append(", sauce=").append(sauce);
        sb.append(", ingredients=").append(ingredients);
        sb.append('}');
        return sb.toString();
    }

    public Bun getBun() {
        return bun;
    }

    public Burgers getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
