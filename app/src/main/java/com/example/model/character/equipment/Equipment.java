package com.example.model.character.equipment;

/**
 * Class describing items equippable by a Character.
 *
 * @author Pedro Falcao
 */
public class Equipment {
    public enum Type {
        ARMOR,
        WEAPON
    }

    /** Name of the Item **/
    public String name;

    /** If the item is an Armor or Weapon **/
    public Type type;

    /** The space where the item goes **/
    public Slot slot;

    /** Armor or damage given by the item **/
    public Long value;

    public Equipment(String name, Type type, Slot slot, Long value) {
        this.name = name;
        this.type = type;
        this.slot = slot;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public Slot getSlot() {
        return this.slot;
    }

    public Long getValue() {
        return this.value;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setType(Type newType) {
        this.type = newType;
    }

    public void setSlot(Slot newSlot) {
        this.slot = newSlot;
    }

    public void setValue(Long newValue) {
        this.value = newValue;
    }
}
