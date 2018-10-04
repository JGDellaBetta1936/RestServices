package com.crunchify.restjersey;

import java.io.Serializable;

//defined as a nested inner class to reduce number of .java files in the example
public class City implements Serializable 
{
    private static final long serialVersionUID = 6392376146163510146L;
    public String name;
    public String country;
    public int population;

    public City( String name, String country, int population ) 
    {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    @Override
    public String toString() 
    {
        return String.format( "%s is a city in the country %s with a population of %d", name, country, population );
    }
}
