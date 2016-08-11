package com.example.model.tests.character.status.health;

import com.example.model.character.status.health.Health;
import com.example.model.tests.character.status.StatusTest;

import org.junit.Before;

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
}
