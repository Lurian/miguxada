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
        Slot slot = equipment.getSlot();
        if (this.equipments.get(slot) == null) {
            this.equipments.put(slot,equipment);
        } else {
            throw new Exception("There is an item already equipped on that slot!");
        }
    }

    public Equipment unequipItem(Slot slot) {
        if (this.equipments.get(slot) == null) {
            return null;
        } else {
            return this.equipments.remove(slot);
        }
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
