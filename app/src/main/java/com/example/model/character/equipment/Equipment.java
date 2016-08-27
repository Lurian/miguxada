package com.example.model.character.equipment;

/**
 * Class describing items equippable by a Character.
 *
 * @author Pedro Falcao
 */
public abstract class Equipment {

    /** Name of the Item **/
    public String name;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
