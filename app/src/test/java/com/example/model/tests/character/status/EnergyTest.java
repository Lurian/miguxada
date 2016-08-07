package com.example.model.tests.character.status;

import com.example.model.character.status.energy.Energy;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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
}
