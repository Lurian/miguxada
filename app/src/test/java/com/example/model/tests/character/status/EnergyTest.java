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
    Long minEnergy = 20L;
    Energy energy;
    Energy energy2;

    @Before
    public void setUp(){

        energy = new Energy(maxEnergy);
        energy2 = new Energy(maxEnergy,minEnergy);
        assertThat(energy, is(notNullValue()));
    }

    @Test
    public void energyModel_decreasesAmount() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        assertThat(energy2.getCurrent(), is(maxEnergy));
        Long amount = 30L;

        energy.decrease(amount);
        energy2.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount));
        assertThat(energy2.getCurrent(), is(maxEnergy - amount));

        energy.decrease(amount);
        energy2.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount * 2));
        assertThat(energy2.getCurrent(), is(maxEnergy - amount * 2));

        energy.decrease(amount);
        energy2.decrease(amount);
        assertThat(energy.getCurrent(), is(maxEnergy - amount * 3));
        assertThat(energy2.getCurrent(), is(maxEnergy - amount * 3));
    }

    @Test
    public void energy_decreaseBelowZero() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        assertThat(energy2.getCurrent(), is(maxEnergy));
        Long amount = maxEnergy;

        energy.decrease(amount);
        energy2.decrease(amount);
        assertThat(energy.getCurrent(), is(0L));
        assertThat(energy.getCurrent(), is(20L));
    }

    @Test
    public void energy_decreaseNegativeArgument() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        try {
            energy.decrease(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative numbers are not accepted!"));
        }
    }

    @Test
    public void energyModel_increasesAmount() {
        energy.decrease(maxEnergy);
        energy2.decrease(maxEnergy);
        assertThat(energy.getCurrent(), is(0L));
        assertThat(energy2.getCurrent(), is(minEnergy));
        Long amount = 30L;

        energy.increase(amount);
        energy2.increase(amount);
        assertThat(energy.getCurrent(), is(amount));
        assertThat(energy2.getCurrent(), is(minEnergy + amount));

        energy.increase(amount);
        energy2.increase(amount);
        assertThat(energy.getCurrent(), is(amount*2));
        assertThat(energy2.getCurrent(), is(minEnergy + amount*2));

        energy.increase(amount);
        energy2.increase(amount);
        assertThat(energy.getCurrent(), is(amount * 3));
        assertThat(energy2.getCurrent(), is(minEnergy + amount * 3));
    }

    @Test
    public void energy_increaseAboveMax() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        Long amount = maxEnergy;

        energy.increase(amount);
        assertThat(energy.getCurrent(), is(100L));
    }

    @Test
    public void energy_increaseNegativeArgument() {
        assertThat(energy.getCurrent(), is(maxEnergy));
        try {
            energy.increase(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative numbers are not accepted!"));
        }
    }


}
