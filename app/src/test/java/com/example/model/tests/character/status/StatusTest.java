package com.example.model.tests.character.status;

import com.example.model.character.status.Status;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Abstract Test Class for Status Objects
 *
 * @author Lucas Andrade, Pedro Falcão
 */
@Ignore
public abstract class StatusTest {
    Long maxStatus = 100L;
    Long minStatus = 20L;
    Status status;
    Status statusWithMin;

    @Test
    public void status_decreasesAmount() {
        assertThat(status.getCurrent(), is(maxStatus));
        assertThat(statusWithMin.getCurrent(), is(maxStatus));
        Long amount = 20L;

        status.decrease(amount);
        statusWithMin.decrease(amount);
        assertThat(status.getCurrent(), is(maxStatus - amount));
        assertThat(statusWithMin.getCurrent(), is(maxStatus - amount));

        status.decrease(amount);
        statusWithMin.decrease(amount);
        assertThat(status.getCurrent(), is(maxStatus - amount * 2));
        assertThat(statusWithMin.getCurrent(), is(maxStatus - amount * 2));

        status.decrease(amount);
        statusWithMin.decrease(amount);
        assertThat(status.getCurrent(), is(maxStatus - amount * 3));
        assertThat(statusWithMin.getCurrent(), is(maxStatus - amount * 3));
    }

    @Test
    public void status_decreaseBelowZero() {
        assertThat(status.getCurrent(), is(maxStatus));
        assertThat(statusWithMin.getCurrent(), is(maxStatus));
        Long amount = maxStatus;

        status.decrease(amount);
        statusWithMin.decrease(amount);
        assertThat(status.getCurrent(), is(0L));
        assertThat(statusWithMin.getCurrent(), is(20L));
    }

    @Test
    public void status_decreaseNegativeArgument() {
        assertThat(status.getCurrent(), is(maxStatus));
        try {
            status.decrease(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative numbers are not accepted!"));
        }
    }

    @Test
    public void status_increasesAmount() {
        status.decrease(maxStatus);
        statusWithMin.decrease(maxStatus);
        assertThat(status.getCurrent(), is(0L));
        assertThat(statusWithMin.getCurrent(), is(minStatus));
        Long amount = 20L;

        status.increase(amount);
        statusWithMin.increase(amount);

        assertThat(status.getCurrent(), is(amount));
        assertThat(statusWithMin.getCurrent(), is(minStatus + amount));

        status.increase(amount);
        statusWithMin.increase(amount);
        assertThat(status.getCurrent(), is(amount*2));
        assertThat(statusWithMin.getCurrent(), is(minStatus + amount*2));

        status.increase(amount);
        statusWithMin.increase(amount);
        assertThat(status.getCurrent(), is(amount * 3));
        assertThat(statusWithMin.getCurrent(), is(minStatus + amount * 3));
    }

    @Test
    public void status_increaseAboveMax() {
        assertThat(status.getCurrent(), is(maxStatus));
        Long amount = maxStatus;

        status.increase(amount);
        assertThat(status.getCurrent(), is(100L));
    }

    @Test
    public void status_increaseNegativeArgument() {
        assertThat(status.getCurrent(), is(maxStatus));
        try {
            status.increase(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative numbers are not accepted!"));
        }
    }
}
