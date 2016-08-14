package com.example.android.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.model.character.Character;

public class StatusScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_screen);

//         Character object for test purposes.
        MyApplication app = (MyApplication) getApplicationContext();
        Character c = app.getCharacter();

        c.getStatus().getEnergy().decrease(1L);

        String health = c.getStatus().getHealth().getCurrent() + "/" + c.getStatus().getHealth().getMax();
        TextView healthValue = (TextView) findViewById(R.id.HealthValue);
        healthValue.setText(health);

        String energy = c.getStatus().getEnergy().getCurrent() + "/" + c.getStatus().getEnergy().getMax();
        TextView energyValue = (TextView) findViewById(R.id.EnergyValue);
        energyValue.setText(energy);
    }
}
