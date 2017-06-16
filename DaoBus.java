package com.example.sabinpopa.pregatire;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by SabinPopa on 14.06.2017.
 */

public class DaoBus {

    DatabaseHelper dbh;

    public DaoBus(DatabaseHelper dbh)
    { this.dbh = dbh;}

    public ArrayList<Bus> getBuses()
    {
        ArrayList<Bus> buses = new ArrayList<Bus>();

        SQLiteDatabase db = dbh.getReadableDatabase();
        Cursor res = db.query(BusDBConstants.busTable, new String[] {BusDBConstants.col2IdVehicle, BusDBConstants.col3Line
                                                       , BusDBConstants.col4Driver, BusDBConstants.col5Places}, null, null, null, null, null);

        res.moveToFirst();
        while(!res.isAfterLast())
        {
            Bus b = new Bus(res.getString(res.getColumnIndex(BusDBConstants.col2IdVehicle)),
                    res.getInt(res.getColumnIndex(BusDBConstants.col3Line)),
                    res.getString(res.getColumnIndex(BusDBConstants.col4Driver)),
                    res.getInt(res.getColumnIndex(BusDBConstants.col5Places)));

            buses.add(b);

            res.moveToNext();
        }

        res.close();
        db.close();

        return buses;
    }

    public void insertBus(Bus b)
    {
        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(BusDBConstants.col2IdVehicle, b.getIdVehicle());
        cv.put(BusDBConstants.col3Line, b.getLineNumber());
        cv.put(BusDBConstants.col4Driver, b.getDriver());
        cv.put(BusDBConstants.col5Places, b.getPlacesNumber());

        db.insert(BusDBConstants.busTable,null, cv);
        db.close();

    }

    public void removeBus(Bus b)
    {
        SQLiteDatabase db = dbh.getWritableDatabase();
        db.delete(BusDBConstants.busTable, BusDBConstants.col2IdVehicle + " = ?", new String[] {b.getIdVehicle()});
    }





}
