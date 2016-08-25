package com.example.model.tests.character.equipment;

import com.example.model.character.equipment.Equipment;
import com.example.model.character.equipment.Slot;
import org.junit.Before;

/**
 * Test Class for @<code>Equipments</code>
 *
 * @author Pedro Falcao
 */
public class EquipmentTest {
    Equipment eq;

    @Before
    public void setUp() {
        this.eq = new Equipment("Unstoppable Force", Equipment.Type.WEAPON,Slot.WEAPON_RIGHT,100L);
    }
}
