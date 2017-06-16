package com.example.sabinpopa.pregatire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by SabinPopa on 13.06.2017.
 */

public class AdaugaAutobuzActivity extends AppCompatActivity{

    EditText idVehicul;
    EditText numeSofer;
    EditText nrLocuri;
    Spinner linie;
    BusApplication busApp;
    int busPosition;
    DaoBus db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        busApp = (BusApplication)this.getApplication();
        db = new DaoBus(new DatabaseHelper(this));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_autobuz);

        Bus b = null;

        try{
            Intent i = getIntent();
            busPosition = i.getIntExtra("busPosition",-1);
            if(busPosition!= -1)
                b = db.getBuses().get(busPosition);

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        numeSofer = (EditText)findViewById(R.id.numeSoferTB);
        idVehicul = (EditText)findViewById(R.id.idVehiculTB);
        nrLocuri = (EditText)findViewById(R.id.nrLocuriTB);
        linie = (Spinner)findViewById(R.id.spinnerLinie);

        if(b!= null)
        {
            numeSofer.setText(b.getDriver());
            idVehicul.setText(b.getIdVehicle());
            nrLocuri.setText(b.getPlacesNumber() + " ");

            String linesStrings[];
            String lineNumber = b.getLineNumber()+" ";
            linesStrings = getResources().getStringArray(R.array.sp_buses_lines);

            for(String line : linesStrings)
            {
                if(Objects.equals(line, lineNumber))
                    linie.setSelection(b.getLineNumber());
            }

        }
    }


    public void saveBus(View view)
    {
        Bus b = new Bus();

        String driver = numeSofer.getText().toString();
        String idVehicle = idVehicul.getText().toString();
        String locuri = nrLocuri.getText().toString();

        if(driver.length() == 0 && idVehicle.length() == 0 && locuri.length() == 0)
        {
            Toast.makeText(this, getString(R.string.campuri_necompletate), Toast.LENGTH_LONG).show();
        }
        else
        {
            b.setDriver(driver);
            b.setIdVehicle(idVehicle);
            b.setPlacesNumber(Integer.valueOf(locuri));
            b.setLineNumber(Integer.valueOf(linie.getSelectedItem().toString()));
            if(busPosition != -1)
            {
                db.removeBus(db.getBuses().get(busPosition));
            }

            db.insertBus(b);

            finish();

        }
    }


}
