package com.example.model.tests.character;

import com.example.model.character.CharacterEquipments;
import com.example.model.character.Slot;
import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.armor.Armor;
import com.example.model.character.equipment.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

/**
 * Test Class for @<code>CharacterEquipments</code>
 *
 * @author Pedro Falcao
 */
public class CharacterEquipmentsTest {
    CharacterEquipments eqs;
    Equipment head;
    Equipment chest;
    Equipment legs;
    Equipment hands;
    Equipment feet;
    Equipment waist;
    Equipment weaponMain;
    Equipment weaponOff;
    Equipment weapon1h;
    Equipment weaponExtra;
    Equipment weapon2h;
    Equipment head2;
    Equipment shield;

    @Before
    public void setUp() {
        this.eqs = new CharacterEquipments();
        head = new Armor("Sassy Beret", Armor.Type.HEADGEAR, 10L);
        chest = new Armor ("Doomhammer's Black Plate", Armor.Type.BODY_ARMOR, 10L);
        legs = new Armor("Prisoner Rags", Armor.Type.LEGWEAR, 10L);
        hands = new Armor("Medic Disposable Gloves", Armor.Type.GLOVES,10L);
        feet = new Armor("Zapatos de Cenicienta", Armor.Type.FOOTWEAR,10L);
        waist = new Armor("MMA World Champion Belt", Armor.Type.BELT,10L);
        weaponMain = new Weapon("Mjölnir", Weapon.Type.MAIN_HANDED, 10L);
        weaponOff = new Weapon("Guts' Cannon Arm", Weapon.Type.OFF_HANDED, 10L);
        weapon1h = new Weapon("Francisca", Weapon.Type.ONE_HANDED, 10L);
        weapon2h = new Weapon("Sword of a Thousand Truths", Weapon.Type.TWO_HANDED,10L);
        shield = new Weapon("Shield of the Cavalier", Weapon.Type.SHIELD,10L);
        head2 = new Armor("Havel's Helm", Armor.Type.HEADGEAR, 10L);
        weaponExtra = new Weapon("Aestus Domus Aurea", Weapon.Type.ONE_HANDED,10L);
    }

    @Test
    public void characterEquipmentsModel_EquipItem() {
        try {
            eqs.equipItem(new Equipment() {}); // Trying to add an unknown item type.
        } catch (Exception e) {
            assertSame("Unknown item type!", e.getMessage());
        }

        try {
            eqs.unequipAll();
            assertTrue(eqs.equipItem(head));
            assertTrue(eqs.equipItem(chest));
            assertTrue(eqs.equipItem(legs));
            assertTrue(eqs.equipItem(hands));
            assertTrue(eqs.equipItem(feet));
            assertTrue(eqs.equipItem(waist));
            assertTrue(eqs.equipItem(weapon2h));
            assertFalse(eqs.equipItem(head2)); // Testing if it is possible to equip another headgear.
            assertFalse(eqs.equipItem(weapon1h)); // Testing if the method accepts equipping another weapon when there's a 2h-weapon already equipped.

            Collection<Equipment> list = new ArrayList<>();
            list.add(head);
            list.add(chest);
            list.add(legs);
            list.add(hands);
            list.add(feet);
            list.add(waist);
            list.add(weapon2h);

            Collection<Equipment> equippedItems = eqs.equipments.values();
            assertThat(equippedItems.containsAll(list)); // If the map really contains all the equipments that were previously added.

            eqs.unequipAll(); // Clear the map
            assertTrue(eqs.equipItem(weaponOff));
            assertEquals(weaponOff,eqs.equipments.get(Slot.WEAPON_LEFT)); // Test if the weapon is really equipped at the off-hand.

            eqs.unequipAll();
            assertTrue(eqs.equipItem(weapon1h));
            assertEquals(weapon1h,eqs.equipments.get(Slot.WEAPON_RIGHT));
            assertTrue(eqs.equipItem(weaponExtra));
            assertEquals(weaponExtra,eqs.equipments.get(Slot.WEAPON_LEFT)); // Checking if it is possible to equip another one-handed weapon.
        } catch (Exception e) {
            e.printStackTrace();
            fail("There shouldn't be an exception in here.");
        }
    }

    @Test
    public void characterEquipmentModel_UnequipItem() {
        // TODO
    }
}
