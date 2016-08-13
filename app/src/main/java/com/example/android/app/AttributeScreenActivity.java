package com.example.android.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.model.character.Character;
import com.example.model.character.CharacterStatus;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

public class AttributeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributes_screen);
    }
}
