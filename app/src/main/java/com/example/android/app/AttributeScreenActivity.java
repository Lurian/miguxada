package com.example.android.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.model.character.Character;

public class AttributeScreenActivity extends AppCompatActivity implements View.OnClickListener {
    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributes_screen);

        // Character object for test purposes.
        MyApplication app = (MyApplication) getApplicationContext();
        Character c = app.getCharacter();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.plusButtonAgi):
                character.getAttribute().getAgility().increase(1L);
                break;
            case (R.id.plusButtonResi):
                character.getAttribute().getResilience().increase(1L);
                break;
            case (R.id.plusButtonReso):
                character.getAttribute().getResolve().increase(1L);
                break;
            case (R.id.plusButtonSta):
                character.getAttribute().getStamina().increase(1L);
                break;
            case (R.id.plusButtonStr):
                character.getAttribute().getStrength().increase(1L);
                break;
            case (R.id.plusButtonWit):
                character.getAttribute().getWit().increase(1L);
                break;
            case (R.id.minusButtonAgi):
                character.getAttribute().getAgility().decrease(1L);
                break;
            case (R.id.minusButtonResi):
                character.getAttribute().getResilience().decrease(1L);
                break;
            case (R.id.minusButtonReso):
                character.getAttribute().getResolve().decrease(1L);
                break;
            case (R.id.minusButtonSta):
                character.getAttribute().getStamina().decrease(1L);
                break;
            case (R.id.minusButtonStr):
                character.getAttribute().getStrength().decrease(1L);
                break;
            case (R.id.minusButtonWit):
                character.getAttribute().getWit().decrease(1L);
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

    private void setAttributeValueStrings() {
        String agility = character.getAttribute().getAgility().getValue().toString();
        TextView agiValue = (TextView) findViewById(R.id.agilityValue);
        agiValue.setText(agility);

        String resilience = character.getAttribute().getResilience().getValue().toString();
        TextView resiValue = (TextView) findViewById(R.id.resilienceValue);
        resiValue.setText(resilience);

        String resolve = character.getAttribute().getResolve().getValue().toString();
        TextView resoValue = (TextView) findViewById(R.id.resolveValue);
        resoValue.setText(resolve);

        String stamina = character.getAttribute().getStamina().getValue().toString();
        TextView staValue = (TextView) findViewById(R.id.staminaValue);
        staValue.setText(stamina);

        String strength = character.getAttribute().getStrength().getValue().toString();
        TextView strValue = (TextView) findViewById(R.id.strengthValue);
        strValue.setText(strength);

        String wit = character.getAttribute().getWit().getValue().toString();
        TextView wValue = (TextView) findViewById(R.id.witValue);
        wValue.setText(wit);
    }
}
