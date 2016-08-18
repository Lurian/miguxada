package com.example.android.app;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.app.databinding.ActivityAtributesScreenBinding;
import com.example.model.character.Character;

public class AttributeScreenActivity extends AppCompatActivity implements View.OnClickListener {
    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributes_screen);

        ActivityAtributesScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_atributes_screen);
        MyApplication app = (MyApplication) getApplicationContext();
        final Character c = app.getCharacter();
        this.character = c;
        binding.setAgility(c.getAttributes().getAgility());
        binding.setResilience(c.getAttributes().getResilience());
        binding.setResolve(c.getAttributes().getResolve());
        binding.setStamina(c.getAttributes().getStamina());
        binding.setStrength(c.getAttributes().getStrength());
        binding.setWit(c.getAttributes().getWit());

        instantiateButtons();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.plusButtonAgi):
                character.getAttributes().getAgility().increase(1L);
                break;
            case (R.id.plusButtonResi):
                character.getAttributes().getResilience().increase(1L);
                break;
            case (R.id.plusButtonReso):
                character.getAttributes().getResolve().increase(1L);
                break;
            case (R.id.plusButtonSta):
                character.getAttributes().getStamina().increase(1L);
                break;
            case (R.id.plusButtonStr):
                character.getAttributes().getStrength().increase(1L);
                break;
            case (R.id.plusButtonWit):
                character.getAttributes().getWit().increase(1L);
                break;
            case (R.id.minusButtonAgi):
                character.getAttributes().getAgility().decrease(1L);
                break;
            case (R.id.minusButtonResi):
                character.getAttributes().getResilience().decrease(1L);
                break;
            case (R.id.minusButtonReso):
                character.getAttributes().getResolve().decrease(1L);
                break;
            case (R.id.minusButtonSta):
                character.getAttributes().getStamina().decrease(1L);
                break;
            case (R.id.minusButtonStr):
                character.getAttributes().getStrength().decrease(1L);
                break;
            case (R.id.minusButtonWit):
                character.getAttributes().getWit().decrease(1L);
                break;
            default:
                break;
        }
    }

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
