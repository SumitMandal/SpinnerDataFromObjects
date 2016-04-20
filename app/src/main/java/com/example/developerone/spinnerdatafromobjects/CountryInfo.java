package com.example.developerone.spinnerdatafromobjects;

public class CountryInfo {
    private String countryName;
    private long countryPopulation;

    public CountryInfo(String cName, long cPopulation) {
        countryName = cName;
        countryPopulation = cPopulation;
    }

    public String getCountryName() {
        return countryName;
    }

    public long getCountryPopulation() {
        return countryPopulation;
    }

    public String toString() {
        return countryName;
    }
}
