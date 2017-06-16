package com.example.sabinpopa.pregatire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int i = item.getItemId();

        if(i == R.id.about)
        {
            Toast.makeText(this,getString(R.string.mesaj_about), Toast.LENGTH_LONG).show();

        }else
            if (i == R.id.adaugaAutobuz) {
                Intent intent1 = new Intent(this, AdaugaAutobuzActivity.class);
                this.startActivity(intent1);
            }

         else
                if( i == R.id.listaAutobuze){
                    Intent intent2 = new Intent(this, BusesList.class);
                            this.startActivity(intent2);
                }


           return true;
    }


}
