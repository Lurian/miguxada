package com.example.model.tests.character;

import com.example.model.character.CharacterEquipments;
import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.Slot;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import static junit.framework.TestCase.fail;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Test Class for @<code>CharacterEquipments</code>
 *
 * @author Pedro Falcao
 */
public class CharacterEquipmentsTest {
    CharacterEquipments eqs;

    @Before
    public void setUp() {
        this.eqs = new CharacterEquipments();
    }

    @Test
    public void characterEquipmentsModel_SimpleConstructor() {
        HashMap<Slot,Equipment> map = new HashMap<>();
        map.put(Slot.WEAPON_RIGHT,null);
        map.put(Slot.WEAPON_LEFT,null);
        map.put(Slot.HEAD,null);
        map.put(Slot.BODY,null);
        map.put(Slot.FEET,null);
        map.put(Slot.HANDS,null);

        assertThat(eqs.getEquipments().keySet().equals(map.keySet()));
        assertThat(eqs.getEquipments().values().equals(map.values()));
    }

    @Test
    public void characterEquipmentsModel_EquipItem() {
        Equipment equipment = new Equipment("Unstoppable Force", Equipment.Type.WEAPON,Slot.WEAPON_RIGHT,100L);

        try {
            eqs.equipItem(equipment);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            eqs.equipItem(equipment);
        } catch (Exception e) {
            assertThat(e.getMessage().equals("There is an item already equipped on that slot!"));
        }
    }

    @Test
    public void characterEquipmentModel_UnequipItem() {
        Equipment equipment = new Equipment("Unstoppable Force", Equipment.Type.WEAPON,Slot.WEAPON_RIGHT,100L);
        try {
            eqs.equipItem(equipment);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertThat(eqs.unequipItem(equipment.getSlot()).equals(equipment));
        assertThat(eqs.unequipItem(equipment.getSlot()) == null);
    }
}
