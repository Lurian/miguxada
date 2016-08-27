package com.example.model.character;

import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.Slot;

import java.util.HashMap;

/**
 * Class that manages the equipments a Character uses.
 *
 * @author Pedro Falcao
 */
public class CharacterEquipments {
    public HashMap<Slot,Equipment> equipments;

    public CharacterEquipments() {
        this.equipments = new HashMap<>();
        this.instantiateMap();
    }

    /**
     * This method instantiates the map with all the keys attached to null elements.
     */
    private void instantiateMap() {
        this.equipments.put(Slot.HEAD,null);
        this.equipments.put(Slot.BODY,null);
        this.equipments.put(Slot.HANDS,null);
        this.equipments.put(Slot.FEET,null);
        this.equipments.put(Slot.WEAPON_LEFT,null);
        this.equipments.put(Slot.WEAPON_RIGHT,null);
    }

    /**
     * This method equips an item in its appropriate slot, if possible. Else it returns an Exception.
     *
     * @param equipment The item to be equipped
     * @throws Exception In case the slot the item goes into is already occupied.
     */
    public void equipItem(Equipment equipment) throws Exception {
        // TODO
    }

    public Equipment unequipItem(Slot slot) {
        // TODO
       return null;
    }

    /**
     * This method empties the map of all equipped items.
     */
    public void unequipAll() {
        equipments.clear();
        instantiateMap();
    }

    public HashMap<Slot, Equipment> getEquipments() {
        return equipments;
    }
}
