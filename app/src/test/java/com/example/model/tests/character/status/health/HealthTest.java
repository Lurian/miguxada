package com.example.model.tests.character.status.health;

import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;
import com.example.model.tests.character.status.StatusTest;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test Class of Health, extends StatusTest
 *
 * @author Lucas Andrade
 */
public class HealthTest extends StatusTest {

    @Before
    public void setUp() {
        super.status = new Health(super.maxStatus);
        super.statusWithMin = new Health(super.maxStatus, super.minStatus);
        assertThat(super.status, is(notNullValue()));
        assertThat(super.statusWithMin, is(notNullValue()));
    }

    @Test
    public void health_canListenToResilence(){
        Resilience resilience = new Resilience(20L);
        Health healthListener = new Health(Health.calculateMaximum(resilience));

        resilience.addACListener(healthListener);

        assertThat(healthListener.getMax(), is(300L));
        resilience.increase(1L);
        assertThat(healthListener.getMax(), is(310L));
        resilience.increase(9L);
        assertThat(healthListener.getMax(), is(400L));
        resilience.decrease(20L);
        assertThat(healthListener.getMax(), is(200L));
    }
}
