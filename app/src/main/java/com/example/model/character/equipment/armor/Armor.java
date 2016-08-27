package com.example.model.character.equipment.armor;

import com.example.model.character.equipment.Equipment;

/**
 * A subtype of Equipment that protects the wearer against damage.
 * @author Pedro Falcao
 */
public class Armor extends Equipment {
    public enum Type {
        HEADWEAR,
        BODY_ARMOR,
        LEGWEAR,
        GLOVES,
        FOOTWEAR,
        BELT
    }

    Type type;
    Long armorValue;

    public Armor(String name, Type type, Long armorValue) {
        this.name = name;
        this.type = type;
        this.armorValue = armorValue;
    }

    public Type getType() {
        return this.type;
    }

    public Long getArmorValue() {
        return this.armorValue;
    }

    public void setType(Type newType) {
        this.type = newType;
    }

    public void setArmorValue(Long newValue) {
        this.armorValue = newValue;
    }
}
