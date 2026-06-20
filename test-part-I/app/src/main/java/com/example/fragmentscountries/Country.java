package com.example.fragmentscountries;

public class Country {
    private final String name;
    private final String capital;
    private final String population;
    private final String language;
    private final String currency;
    private final String continent;

    public Country(String name, String capital, String population, String language, String currency, String continent) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.language = language;
        this.currency = currency;
        this.continent = continent;
    }

    public String getName()       { return name; }
    public String getCapital()    { return capital; }
    public String getPopulation() { return population; }
    public String getLanguage()   { return language; }
    public String getCurrency()   { return currency; }
    public String getContinent()  { return continent; }
}
