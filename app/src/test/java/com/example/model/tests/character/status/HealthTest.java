package com.example.model.tests.character.status;

import com.example.model.character.status.health.Health;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lucas on 06/08/2016.
 */
public class HealthTest {
    Long maxLife = 100L;
    Health health;

    @Before
    public void setUp(){
        health = new Health(maxLife);
    }

    @Test
    public void healthModel_decreasesAmount() {
        assertThat(health.getCurrent(), is(maxLife));

        Long amount = 30L;
        health.decrease(amount);

        assertThat(health.getCurrent(), is(maxLife - amount));
    }

    @Test
    public void healthModel_increasesAmount() {
        assertThat(health.getCurrent(), is(maxLife));

        Long amount = 30L;
        health.decrease(amount);

        assertThat(health.getCurrent(), is(maxLife - amount));

        health.increase(amount);

        assertThat(health.getCurrent(), is(maxLife));
    }
}
