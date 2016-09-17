package com.example.model.character;

import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.armor.Armor;
import com.example.model.character.equipment.weapon.Weapon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import static com.example.model.character.Slot.*;

/**
 * Class that manages the equipments a Character uses.
 *
 * @author Pedro Falcao
 */
public class CharacterEquipments {
    public HashMap<Slot, Equipment> equipments;

    public CharacterEquipments() {
        this.equipments = new HashMap<>();
        this.instantiateMap();
    }

    /**
     * This method instantiates the map with all the keys attached to null elements.
     */
    private void instantiateMap() {
        this.equipments.put(Slot.HEAD, null);
        this.equipments.put(Slot.CHEST, null);
        this.equipments.put(Slot.LEGS, null);
        this.equipments.put(Slot.HANDS, null);
        this.equipments.put(Slot.FEET, null);
        this.equipments.put(Slot.WAIST, null);
        this.equipments.put(Slot.WEAPON_LEFT, null);
        this.equipments.put(Slot.WEAPON_RIGHT, null);
    }

    /**
     * This method equips an equipment in its appropriate slot, if possible, and returns if the equip action was successful. If not possible to equip,it throws an Exception.
     *
     * @param equipment The equipment to be equipped.
     * @return If the equip action was successful.
     * @throws Exception If either the Slot or the Item Type were not recognized.
     */
    public boolean equipItem(Equipment equipment) throws Exception {
        Slot slot = CharacterEquipments.assignSlot(equipment);
        if (this.canEquipAt(slot)) {
            if (equipment instanceof Weapon) {
                Weapon.Type weaponType = ((Weapon) equipment).getType();
                if (weaponType == Weapon.Type.TWO_HANDED && !this.canEquipAt(slot)) {
                    return false;
                }
            }
            equipments.put(slot,equipment);
            return true;
        } else {
            if (equipment instanceof Weapon) {
                Weapon.Type weaponType = ((Weapon) equipment).getType();
                if (weaponType == Weapon.Type.ONE_HANDED) {
                    slot = WEAPON_LEFT;
                    if (this.canEquipAt(slot)) {
                        equipments.put(slot,equipment);
                        return true;
                    }
                }
            }
        } return false;
    }

    /**
     * Checks if there are no items equipped in the given slot.
     *
     * @param slot The slot to be checked.
     * @throws Exception in case the slot was not recognized.
     * @return True in case the slot is empty. False in case the slot is occupied.
     */
    public boolean canEquipAt(Slot slot) throws Exception {
        if (equipments.containsKey(slot)) {
            if (slot == WEAPON_LEFT && this.equipments.get(WEAPON_RIGHT) != null) {
                if (((Weapon) this.equipments.get(WEAPON_RIGHT)).getType() == Weapon.Type.TWO_HANDED) {
                    return false;
                }
            }
            boolean isSlotEmpty = (this.equipments.get(slot) == null);
            return isSlotEmpty;
        } throw new Exception("There is no such slot!");
    }

    /**
     * This method examines in which slot the character should put the given Equipment. It throws an exception if the item type was not recognized.
     *
     * @param equipment The item to be attributed to a slot.
     * @return The slot in which the item should fit.
     * @throws Exception If the item doesn't belong to any known slot or if the item type was not recognized.
     */
    public static Slot assignSlot(Equipment equipment) throws Exception {
        if (equipment instanceof Armor) {
            Armor.Type type = ((Armor) equipment).getType();
            switch (type) {
                case HEADGEAR:
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
        } else if (equipment instanceof Weapon) {
            Weapon.Type type = ((Weapon) equipment).getType();
            switch (type) {
                case ONE_HANDED:
                    return Slot.WEAPON_RIGHT;
                case TWO_HANDED:
                    return WEAPON_RIGHT;
                case MAIN_HANDED:
                    return Slot.WEAPON_RIGHT;
                case OFF_HANDED:
                    return Slot.WEAPON_LEFT;
                case SHIELD:
                    return Slot.WEAPON_LEFT;
                default:
                    throw new Exception("The item does not fit in any of the default slots!");
            }
        } else {
            throw new Exception("Unknown item type!");
        }
    }

    /**
     * This method unequips an Equipment that may be present in the given slot.Throws an exception if the slot does not exist, else it shows the item that was unequipped or null when there was no item equipped. In case the item is a two-handed weapon, it also unequips the other hand.
     *
     * @param slot The slot from where the item should be removed.
     * @return The item equipped on the given slot or null when the slot is empty.
     * @throws Exception If the slot passed does not exist on this Character.
     */
    public Equipment unequipItem(Slot slot) throws Exception {
        if (this.equipments.containsKey(slot)) {
            Equipment removed = this.equipments.remove(slot);
            if (removed instanceof Weapon) {
                this.equipments.put(slot, null);
                return removed;
            }
        } throw new Exception("Unknown slot.");
    }

    /**
     * This method strips the character of all equipped items.
     *
     * @return An ArrayList with the Equipments removed.
     */
    public Collection<Equipment> unequipAll() {
        Collection<Equipment> unequipped = equipments.values();
        equipments.clear();
        instantiateMap();
        return unequipped;
    }

    /**
     * This method gathers all the equipped items in an ArrayList of Equipments.It also treats the case in which the character (to avoid a duplicated weapon).
     *
     * @return An ArrayList of Equipment objects containing the items currently equipped by the character.
     */
    @SuppressWarnings("unchecked")
    public Collection<Equipment> getEquipments() {
        HashMap<Slot, Equipment> currentEquipments = (HashMap<Slot, Equipment>) this.equipments.clone();
        return currentEquipments.values();
    }

    public Set<Slot> getSlots() {
        return this.equipments.keySet();
    }
}
