package com.example.model.tests.character;

import com.example.model.character.Character;
import com.example.model.character.CharacterStatus;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Test Class for @<code>CharacterStatus</code>
 * @author Pedro Falcao
 */
public class CharacterStatusTest {

    @Test
    public void characterStatusModel_SimpleConstructor() {
        Health health = new Health(100L);
        Energy energy = new Energy(100L);
        CharacterStatus charStat = new CharacterStatus(health,energy);

        assertThat(charStat.getHealth(),is(health));
        assertThat(charStat.getEnergy(),is(energy));
    }
}
