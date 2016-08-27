package com.example.model.character.equipment.armor;

import com.example.model.character.equipment.Equipment;

/**
 * A subtype of Equipment that protects the wearer against damage.
 * @author Pedro Falcao
 */
public class Armor extends Equipment {
    public enum ArmorType {
        HEADWEAR,
        BODY_ARMOR,
        LEGWEAR,
        GLOVES,
        BOOTS,
        BELT
    }

    ArmorType type;
    Long armorValue;

    public Armor(String name, ArmorType type, Long armorValue) {
        this.name = name;
        this.type = type;
        this.armorValue = armorValue;
    }

    public ArmorType getType() {
        return this.type;
    }

    public Long getArmorValue() {
        return this.armorValue;
    }

    public void setType(ArmorType newType) {
        this.type = newType;
    }

    public void setArmorValue(Long newValue) {
        this.armorValue = newValue;
    }
}
