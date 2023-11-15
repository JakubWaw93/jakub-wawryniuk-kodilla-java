package com.kodilla.stream.world;

import java.util.List;
import java.util.Objects;

public final class Continent {

    private final String continentName;
    private final List<Country> countries;

    public Continent(final String continentName,final List<Country> countries) {
        this.continentName = continentName;
        this.countries = countries;
    }

    public void addCountry(Country country){
        countries.add(country);
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        if (!Objects.equals(continentName, continent.continentName))
            return false;
        return Objects.equals(countries, continent.countries);
    }

    @Override
    public int hashCode() {
        int result = continentName != null ? continentName.hashCode() : 0;
        result = 31 * result + (countries != null ? countries.hashCode() : 0);
        return result;
    }
}
