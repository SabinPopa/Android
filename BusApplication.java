package com.example.sabinpopa.pregatire;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by SabinPopa on 13.06.2017.
 */

public class BusApplication extends Application {

    ArrayList<Bus> buses;

    public BusApplication() {
        this.buses = new ArrayList<Bus>(0);
    }

    public BusApplication(ArrayList<Bus> buses)
    {
        this.buses=buses;
    }

    public ArrayList<Bus> getBuses()
    {
        return buses;
    }

    public void setBuses(ArrayList<Bus> buses)
    {
        this.buses=buses;
    }

    public Bus getBus(int i)
    {
        return buses.get(i);
    }

    public void addBus(Bus bus)
    {
        buses.add(bus);
    }

    public void removeBus(Bus b)
    {
        buses.remove(b);
    }






}
