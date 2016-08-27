package com.example.model.character.equipment.weapon;

import com.example.model.character.equipment.Equipment;

/**
 * A subtype of equipment that deals damage.
 * @author Pedro Falcao
 */
public class Weapon extends Equipment {
    public enum WeaponType {
        ONE_HANDED,
        TWO_HANDED,
        RIGHT_HANDED,
        LEFT_HANDED,
    }

    public String name;
    public WeaponType type;
    public Long damageValue;

    public Weapon(String name, WeaponType type, Long damageValue) {
        this.name = name;
        this.type = type;
        this.damageValue = damageValue;
    }

    public WeaponType getType() {
        return this.type;
    }

    public Long getDamageValue() {
        return this.damageValue;
    }

    public void setType(WeaponType newType) {
        this.type = newType;
    }

    public void setDamageValue(Long newValue) {
        this.damageValue = newValue;
    }
}
