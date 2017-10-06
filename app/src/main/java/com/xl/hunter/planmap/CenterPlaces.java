package com.xl.hunter.planmap;

/**
 * Created by hunter on 6/10/17.
 */

public class CenterPlaces {
    private String name;
    private double longitude;
    private double latitude;

    public CenterPlaces(String name,double longitude,double latitude)
    {
        this.name=name;
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public String getName()
    {
        return name;
    }
    private double getLongitude()
    {
        return longitude;

    }

    private double getLatitude()
    {
        return latitude;
    }
}
