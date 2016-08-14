package com.example.model.character;

import android.os.Parcelable;

import com.example.model.character.attribute.agility.Agility;
import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.resolve.Resolve;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.attribute.strength.Strength;
import com.example.model.character.attribute.wit.Wit;

import java.io.Serializable;

/**
 * Class managing the basic attributes of a character.
 * @author Lucas Andrade
 */
public class CharacterAttributes implements Serializable{
    private Agility agility;
    private Resilience resilience;
    private Resolve resolve;
    private Stamina stamina;
    private Strength strength;
    private Wit wit;

    public CharacterAttributes(Agility agility, Resilience resilience, Resolve resolve, Stamina stamina, Strength strength, Wit wit) {
        this.agility = agility;
        this.resilience = resilience;
        this.resolve = resolve;
        this.stamina = stamina;
        this.strength = strength;
        this.wit = wit;
    }

    public Agility getAgility() {
        return agility;
    }

    public void setAgility(Agility agility) {
        this.agility = agility;
    }

    public Resilience getResilience() {
        return resilience;
    }

    public void setResilience(Resilience resilience) {
        this.resilience = resilience;
    }

    public Resolve getResolve() {
        return resolve;
    }

    public void setResolve(Resolve resolve) {
        this.resolve = resolve;
    }

    public Stamina getStamina() {
        return stamina;
    }

    public void setStamina(Stamina stamina) {
        this.stamina = stamina;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public Wit getWit() {
        return wit;
    }

    public void setWit(Wit wit) {
        this.wit = wit;
    }
}
