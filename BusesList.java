package com.example.sabinpopa.pregatire;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SabinPopa on 14.06.2017.
 */

public class BusesList extends ListActivity {

    BusApplication busApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        busApp = (BusApplication)getApplication();
        DaoBus db = new DaoBus(new DatabaseHelper(this));

        final ArrayList<String> stringBuses = new ArrayList<String>();

        for(Bus b : db.getBuses() )
        {
            stringBuses.add(b.getIdVehicle());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringBuses);
        setListAdapter(adapter);
        runOnUiThread(new Runnable(){
            public void run(){ adapter.notifyDataSetChanged();}

        });

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        Intent i = new Intent(this, AdaugaAutobuzActivity.class);
        i.putExtra("busPosition", position);
        startActivity(i);
        super.onListItemClick(l, v, position, id);

    }


}
