package com.example.model.tests.character;

import com.example.model.character.Character;
import com.example.model.character.CharacterStatus;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Test Class for @<code>Character</code>
 *
 * @author Lucas Andrade
 */
public class CharacterTest {

    @Test
    public void characterModel_SimpleConstructor() {
        String name = "name";
        String biography = "biography";
        Health h = new Health(100L);
        Energy e = new Energy(100L);
        CharacterStatus charStat = new CharacterStatus(h,e);

        Character char1 = new Character(name, biography,charStat);

        assertThat(char1.getBiography(), is(biography));
        assertThat(char1.getName(), is(name));
        assertThat(char1.getStatus().getHealth(),is(h));
    }
}
