package com.example.android.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.app.databinding.ActivityStatusScreenBinding;
import com.example.model.character.Character;

public class StatusScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStatusScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_status_screen);
        MyApplication app = (MyApplication) getApplicationContext();
        Character c = app.getCharacter();
        binding.setCharacter(c);
    }
}
