package com.example.model.character.equipment.weapon;

import com.example.model.character.equipment.Equipment;

/**
 * A subtype of equipment that deals damage.
 * @author Pedro Falcao
 */
public class Weapon extends Equipment {
    public enum Type {
        ONE_HANDED,
        TWO_HANDED,
        MAIN_HANDED,
        OFF_HANDED,
        SHIELD
    }

    public String name;
    public Type type;
    public Long damageValue;

    public Weapon(String name, Type type, Long damageValue) {
        this.name = name;
        this.type = type;
        this.damageValue = damageValue;
    }

    public Type getType() {
        return this.type;
    }

    public Long getDamageValue() {
        return this.damageValue;
    }

    public void setType(Type newType) {
        this.type = newType;
    }

    public void setDamageValue(Long newValue) {
        this.damageValue = newValue;
    }
}
