package com.example.model.tests.character;

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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class for @<code>CharacterStatuses</code>
 *
 * @author Lucas Andrade
 */
public class CharacterAttributesTest {

    @Test
    public void characterStatusModel_SimpleConstructor() {
        Agility agility = new Agility(10L);
        Resilience resilience = new Resilience(10L);
        Resolve resolve = new Resolve(10L);
        Stamina stamina = new Stamina(10L);
        Strength strength = new Strength(10L);
        Wit wit = new Wit(10L);

        CharacterAttributes charAttr = new CharacterAttributes(agility, resilience, resolve, stamina, strength, wit);

        assertThat(charAttr.getAgility(), is(agility));
        assertThat(charAttr.getResilience(), is(resilience));
        assertThat(charAttr.getResolve(), is(resolve));
        assertThat(charAttr.getStamina(), is(stamina));
        assertThat(charAttr.getStrength(), is(strength));
        assertThat(charAttr.getWit(), is(wit));
    }
}
