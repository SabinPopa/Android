package com.example.sabinpopa.pregatire;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SabinPopa on 13.06.2017.
 */

public class Bus implements Parcelable {

    private String idVehicle;
    private int lineNumber;
    private String driver;
    private int placesNumber;

    public Bus()
    {}

    public Bus(String idVehicle, int lineNumber, String driver, int placesNumber) {
        this.idVehicle = idVehicle;
        this.lineNumber = lineNumber;
        this.driver = driver;
        this.placesNumber = placesNumber;
    }


    protected Bus(Parcel in) {
        idVehicle = in.readString();
        lineNumber = in.readInt();
        driver = in.readString();
        placesNumber = in.readInt();

    }

    public static final Creator<Bus> CREATOR = new Creator<Bus>()
    {

        @Override
        public Bus[] newArray(int size) {
            return new Bus[size];
        }

        @Override
        public Bus createFromParcel(Parcel in) {

            return new Bus(in);
        }

    };



    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getPlacesNumber() {
        return placesNumber;
    }

    public void setPlacesNumber(int placesNumber) {
        this.placesNumber = placesNumber;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(idVehicle);
            dest.writeInt(lineNumber);
            dest.writeString(driver);
            dest.writeInt(placesNumber);
    }
}
