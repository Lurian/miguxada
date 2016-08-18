package com.example.android.app;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.android.app.databinding.ActivityAttributesScreenBinding;
import com.example.model.character.Character;

public class AttributeScreenActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attributes_screen);

        ActivityAttributesScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_attributes_screen);
        MyApplication app = (MyApplication) getApplicationContext();
        final Character c = app.getCharacter();
        binding.setAgility(c.getAttributes().getAgility());
        binding.setResilience(c.getAttributes().getResilience());
        binding.setResolve(c.getAttributes().getResolve());
        binding.setStamina(c.getAttributes().getStamina());
        binding.setStrength(c.getAttributes().getStrength());
        binding.setWit(c.getAttributes().getWit());

        instantiateButtons();
    }

    @Override
    public void onClick(View view) {}

    /**
    * This method instantiates the minus and plus buttons for each attribute in the activity.
    * */
    private void instantiateButtons() {
        final Button agiPlus = (Button) findViewById(R.id.plusButtonAgi);
        agiPlus.setOnClickListener(this);
        final Button resiPlus = (Button) findViewById(R.id.plusButtonResi);
        resiPlus.setOnClickListener(this);
        final Button resoPlus = (Button) findViewById(R.id.plusButtonReso);
        resoPlus.setOnClickListener(this);
        final Button staPlus = (Button) findViewById(R.id.plusButtonSta);
        staPlus.setOnClickListener(this);
        final Button strPlus = (Button) findViewById(R.id.plusButtonStr);
        strPlus.setOnClickListener(this);
        final Button witPlus = (Button) findViewById(R.id.plusButtonWit);
        witPlus.setOnClickListener(this);
        final Button agiMinus = (Button) findViewById(R.id.minusButtonAgi);
        agiMinus.setOnClickListener(this);
        final Button resiMinus = (Button) findViewById(R.id.minusButtonResi);
        resiMinus.setOnClickListener(this);
        final Button resoMinus = (Button) findViewById(R.id.minusButtonReso);
        resoMinus.setOnClickListener(this);
        final Button staMinus = (Button) findViewById(R.id.minusButtonSta);
        staMinus.setOnClickListener(this);
        final Button strMinus = (Button) findViewById(R.id.minusButtonStr);
        strMinus.setOnClickListener(this);
        final Button witMinus = (Button) findViewById(R.id.minusButtonWit);
        witMinus.setOnClickListener(this);
    }
}
