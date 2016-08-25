package com.example.model.tests.character;

import com.example.model.character.Character;
import com.example.model.character.CharacterAttributes;
import com.example.model.character.attribute.agility.Agility;
import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.resolve.Resolve;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.attribute.strength.Strength;
import com.example.model.character.attribute.wit.Wit;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
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

        Agility agility = new Agility(10L);
        Resilience resilience = new Resilience(10L);
        Resolve resolve = new Resolve(10L);
        Stamina stamina = new Stamina(10L);
        Strength strength = new Strength(10L);
        Wit wit = new Wit(10L);

        CharacterAttributes charAttr = new CharacterAttributes(agility,resilience,resolve,stamina,strength,wit);

        Character char1 = new Character(name, biography, charAttr);

        assertThat(char1.getBiography(), is(biography));
        assertThat(char1.getName(), is(name));
        assertNotNull(char1.getStatuses());

        Health h = char1.getStatuses().getHealth();
        assertNotNull(char1.getStatuses().getHealth());
        assertThat(h.getMax(), is(100+(resilience.getValue()*10)));
        assertThat(h.getCurrent(), is(100+(resilience.getValue()*10)));

        Energy e = char1.getStatuses().getEnergy();
        assertNotNull(char1.getStatuses().getEnergy());
        assertThat(e.getMax(), is(100+(stamina.getValue()*10)));
        assertThat(e.getCurrent(), is(100+(stamina.getValue()*10)));
    }
}
