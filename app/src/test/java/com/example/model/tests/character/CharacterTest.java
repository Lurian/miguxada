package com.example.model.tests.character;

import com.example.model.character.Character;
import com.example.model.character.CharacterAttributes;
import com.example.model.character.CharacterStatuses;
import com.example.model.character.attribute.agility.Agility;
import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.resolve.Resolve;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.attribute.strength.Strength;
import com.example.model.character.attribute.wit.Wit;
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
        CharacterStatuses charStat = new CharacterStatuses(h,e);

        Agility agility = new Agility(10L);
        Resilience resilience = new Resilience(10L);
        Resolve resolve = new Resolve(10L);
        Stamina stamina = new Stamina(10L);
        Strength strength = new Strength(10L);
        Wit wit = new Wit(10L);

        CharacterAttributes charAttr = new CharacterAttributes(agility,resilience,resolve,stamina,strength,wit);

        Character char1 = new Character(name, biography,charStat, charAttr);

        assertThat(char1.getBiography(), is(biography));
        assertThat(char1.getName(), is(name));
        assertThat(char1.getStatuses().getHealth(),is(h));
        assertThat(char1.getAttributes().getStrength(), is(strength));
    }
}
