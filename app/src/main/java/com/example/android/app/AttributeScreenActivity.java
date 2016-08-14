package com.example.android.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.model.character.Character;

public class AttributeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributes_screen);

        // Character object for test purposes.
        Bundle b = this.getIntent().getExtras();
        Character c;
        if (b != null) {
            c = (Character) b.getSerializable("TestChar");
        }
    }
}
