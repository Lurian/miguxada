package com.example.model.tests.character.status;

import com.example.model.character.status.energy.Energy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Pedro on 06/08/2016.
 */
public class EnergyTest {
    Long maxEnergy = 100L;
    Energy energy;

    @Before
    public void setUp(){

        energy = new Energy(maxEnergy);
        assertThat(energy, is(notNullValue()));
    }

    @Test
    public void energyModel_decreasesAmount() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        Long amount = 30L;

        energy.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount));

        energy.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount*2));

        energy.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount*3));

        energy.decrease(amount);
        assertThat(energy.getCurrent(), is(0L));

        energy.decrease(amount);
        assertThat(energy.getCurrent(), is(0L));

        try {
            energy.decrease(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative Argument!"));
        }
    }

    @Test
    public void energyModel_increasesAmount() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        Long amount = 30L;

        energy.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount));
        energy.increase(amount);
        assertThat(energy.getCurrent(), is(maxEnergy));

        energy.increase(amount);
        assertThat(energy.getCurrent(), is(maxEnergy));

        energy.decrease(100L);
        assertThat(energy.getCurrent(), is(0L));
        energy.increase(amount);
        assertThat(energy.getCurrent(),is(0L + amount));

        try {
            energy.increase(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative Argument!"));
        }
    }
}
