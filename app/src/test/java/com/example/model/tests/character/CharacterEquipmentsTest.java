package com.example.model.tests.character;

import com.example.model.character.CharacterEquipments;
import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.Slot;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
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
        map.put(Slot.CHEST,null);
        map.put(Slot.LEGS,null);
        map.put(Slot.FEET,null);
        map.put(Slot.HANDS,null);

        assertThat(eqs.getEquipments().keySet().equals(map.keySet()));
        assertThat(eqs.getEquipments().values().equals(map.values()));
    }

    @Test
    public void characterEquipmentsModel_EquipItem() {
        // TODO
    }

    @Test
    public void characterEquipmentModel_UnequipItem() {
        // TODO
    }
}
