package com.example.sabinpopa.pregatire;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SabinPopa on 14.06.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, BusDBConstants.dbName, null, BusDBConstants.dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BusDBConstants.queryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(BusDBConstants.deleteBusesTable);
        onCreate(db);

    }
}
