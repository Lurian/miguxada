package com.example.model.tests.character;

import com.example.model.character.Character;

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

        Character char1 = new Character(name, biography);

        assertThat(char1.getBiography(), is(biography));
        assertThat(char1.getName(), is(name));
    }
}
