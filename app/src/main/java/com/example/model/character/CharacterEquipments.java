package com.example.model.character;

import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.Slot;
import com.example.model.character.equipment.armor.Armor;
import com.example.model.character.equipment.weapon.Weapon;
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
        this.equipments.put(Slot.CHEST,null);
        this.equipments.put(Slot.LEGS,null);
        this.equipments.put(Slot.HANDS,null);
        this.equipments.put(Slot.FEET,null);
        this.equipments.put(Slot.WAIST,null);
        this.equipments.put(Slot.WEAPON_LEFT,null);
        this.equipments.put(Slot.WEAPON_RIGHT,null);
    }

    /**
     * This method equips an item in its appropriate slot, if possible. Else it returns an Exception.
     *
     * @param equipment The item to be equipped.
     * @throws Exception In case the slot the item goes into is already occupied.
     */
    public void equipItem(Equipment equipment) throws Exception {
        Slot slot = this.getSlot(equipment);
        if (slot.equals(Slot.WEAPON_BOTH)) {
            if (this.equipments.get(Slot.WEAPON_RIGHT) == null && this.equipments.get(Slot.WEAPON_LEFT) == null) {
                this.equipments.put(Slot.WEAPON_RIGHT, equipment);
                this.equipments.put(Slot.WEAPON_LEFT,equipment);
            } else {
                throw new Exception("One or both slots are already taken. Please empty those slots first.");
            }
        } else if (slot.equals(Slot.WEAPON_ANY)) {
            if (this.equipments.get(Slot.WEAPON_RIGHT) == null) {
                this.equipments.put(Slot.WEAPON_RIGHT,equipment);
            } else if (this.equipments.get(Slot.WEAPON_LEFT) == null) {
                this.equipments.put(Slot.WEAPON_LEFT,equipment);
            } else {
                throw new Exception("That slot already has an item. Please empty that slot first.");
            }
        } else {
            if (this.equipments.get(slot) == null) {
                this.equipments.put(slot,equipment);
            } else {
                throw new Exception("That slot already has an item. Please empty that slot first.");
            }
        }
    }

    /**
     * This method examines in which slot the character should put the given Equipment. It throws an exception if the item type was not recognized.
     *
     * @param equipment The item to be attributed to a slot.
     * @return The slot in which the item should fit.
     * @throws Exception If the item doesn't belong to any known slot or if the item type was not recognized.
     */
    public Slot getSlot(Equipment equipment) throws Exception {
        if (equipment.getClass().equals(Armor.class)) {
            Armor.Type type = ((Armor) equipment).getType();
            switch (type) {
                case HEADWEAR:
                    return Slot.HEAD;
                case BODY_ARMOR:
                    return Slot.CHEST;
                case LEGWEAR:
                    return Slot.LEGS;
                case GLOVES:
                    return Slot.HANDS;
                case FOOTWEAR:
                    return Slot.FEET;
                case BELT:
                    return Slot.WAIST;
                default:
                    throw new Exception("The item does not fit in any of the default slots!");
            }
        } else if (equipment.getClass().equals(Weapon.class)) {
            Weapon.Type type = ((Weapon) equipment).getType();
            switch (type) {
                case ONE_HANDED:
                    return Slot.WEAPON_ANY;
                case TWO_HANDED:
                    return Slot.WEAPON_BOTH;
                case MAIN_HANDED:
                    return Slot.WEAPON_RIGHT;
                case OFF_HANDED:
                    return Slot.WEAPON_LEFT;
                default:
                    throw new Exception("The item does not fit in any of the default slots!");
            }
        } else {
            throw new Exception("Unknown item type!");
        }
    }

    /**
     * This method unequips an Equipment that may be present in the given slot.Throws an exception if the slot does not exist, else it shows the item that was unequipped or null when there was no item equipped.
     *
     * @param slot The slot from where the item should be removed.
     * @return The item equipped on the given slot or null when the slot is empty.
     * @throws Exception If the slot passed does not exist on this Character.
     */
    public Equipment unequipItem(Slot slot) throws Exception {
        if (this.equipments.containsKey(slot)) {
            Equipment removed = this.equipments.remove(slot);
            this.equipments.put(slot, null);
            return removed;
        } else {
            throw new Exception("Unknown slot.");
        }
    }

    /**
     * This method unequips all the equipped items.
     */
    public void unequipAll() {
        equipments.clear();
        instantiateMap();
    }

    public HashMap<Slot, Equipment> getEquipments() {
        return equipments;
    }
}
