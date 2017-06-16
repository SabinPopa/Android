package com.example.sabinpopa.pregatire;

/**
 * Created by SabinPopa on 14.06.2017.
 */

public class BusDBConstants {

    public static final String dbName = "bus_manager_db";
    public static final int dbVersion = 1;
    public static final String busTable = "buses";
    public static final String col1Id = "id";
    public static final String col2IdVehicle = "idVehicle";
    public static final String col3Line = "linie";
    public static final String col4Driver = "driver";
    public static final String col5Places = "places";

    public static final String queryCreate = "CREATE TABLE  " + busTable + " ( "
             + col1Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
             + col2IdVehicle + " TEXT, "
             + col3Line + " INTEGER, "
             + col4Driver + " TEXT, "
             + col5Places + " INTEGER) ; ";

    public static final String getBuses = "SELECT * FROM " + busTable + ";";
    public static final String deleteBusesTable = "DROP TABLE IF EXIST " + busTable + ";";


}
