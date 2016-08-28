package com.example.model.tests.character;

import com.example.model.character.CharacterEquipments;
import com.example.model.character.equipment.Equipment;
import com.example.model.character.Slot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        //TODO
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
