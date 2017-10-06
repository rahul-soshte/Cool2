package com.xl.hunter.planmap;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by hunter on 6/10/17.
 */

public class CenterPlaces implements Serializable{
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

    public double getLongitude()
    {
        return longitude;

    }

    public double getLatitude()
    {
        return latitude;
    }
}
