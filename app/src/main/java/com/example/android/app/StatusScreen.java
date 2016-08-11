package com.example.android.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.model.character.Character;
import com.example.model.character.CharacterStatus;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

public class StatusScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_screen);

        // Instancing a Character object for test purposes.
        Character c = new Character("João", "", new CharacterStatus(new Health(100L), new Energy(100L)));

        String health = c.getStatus().getHealth().getCurrent() + "/" + c.getStatus().getHealth().getMax();
        TextView healthValue = (TextView) findViewById(R.id.HealthValue);
        healthValue.setText(health);

        String energy = c.getStatus().getEnergy().getCurrent() + "/" + c.getStatus().getEnergy().getMax();
        TextView energyValue = (TextView) findViewById(R.id.EnergyValue);
        energyValue.setText(energy);
    }
}
