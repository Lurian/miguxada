package com.example.model.tests.character;

import com.example.model.character.CharacterStatuses;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Test Class for @<code>CharacterStatuses</code>
 * @author Pedro Falcao
 */
public class CharacterStatusesTest {

    @Test
    public void characterStatusModel_SimpleConstructor() {
        Health health = new Health(100L);
        Energy energy = new Energy(100L);
        CharacterStatuses charStat = new CharacterStatuses(health,energy);

        assertThat(charStat.getHealth(),is(health));
        assertThat(charStat.getEnergy(),is(energy));
    }
}
