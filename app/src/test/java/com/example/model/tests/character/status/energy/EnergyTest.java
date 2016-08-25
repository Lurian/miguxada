package com.example.model.tests.character.status.energy;

import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.status.energy.Energy;
import com.example.model.tests.character.status.StatusTest;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test Class of Health, extends StatusTest
 *
 * @author Lucas Andrade
 */
public class EnergyTest extends StatusTest {

    @Before
    public void setUp() {
        super.status = new Energy(super.maxStatus);
        super.statusWithMin = new Energy(super.maxStatus, super.minStatus);
        assertThat(super.status, is(notNullValue()));
        assertThat(super.statusWithMin, is(notNullValue()));
    }

    @Test
    public void energy_canListenToStamina(){
        Stamina stamina = new Stamina(20L);
        Energy energyListener = new Energy(Energy.calculateMaximum(stamina));

        stamina.addACListener(energyListener);

        assertThat(energyListener.getMax(), is(300L));
        stamina.increase(1L);
        assertThat(energyListener.getMax(), is(310L));
        stamina.increase(9L);
        assertThat(energyListener.getMax(), is(400L));
        stamina.decrease(20L);
        assertThat(energyListener.getMax(), is(200L));
    }
}
