package com.example.model.tests.character.attribute;

import com.example.model.character.attribute.Attribute;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Abstract Test Class for Status Objects
 *
 * @author Lucas Andrade
 */
@Ignore
public abstract class AttributeTest {
    protected Attribute attribute;
    protected Long initialValue = 50L;

    @Test
    public void status_decreasesAmount() {
        assertThat(attribute.getValue(), is(initialValue));
        Long amount = 10L;

        attribute.decrease(amount);
        assertThat(attribute.getValue(), is(initialValue - amount));

        attribute.decrease(amount);
        assertThat(attribute.getValue(), is(initialValue - amount * 2));

        attribute.decrease(amount);
        assertThat(attribute.getValue(), is(initialValue - amount * 3));
    }

    @Test
    public void status_decreaseBelowZero() {
        assertThat(attribute.getValue(), is(initialValue));

        attribute.decrease(initialValue + 1L);
        assertThat(attribute.getValue(), is(1L));
    }

    @Test
    public void status_decreaseNegativeArgument() {
        assertThat(attribute.getValue(), is(initialValue));
        try {
            attribute.decrease(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative numbers are not accepted!"));
        }
    }

    @Test
    public void status_increasesAmount() {
        attribute.decrease(initialValue);
        assertThat(attribute.getValue(), is(1L));
        Long amount = 10L;

        attribute.increase(amount - 1L);

        assertThat(attribute.getValue(), is(amount));

        attribute.increase(amount);
        assertThat(attribute.getValue(), is(amount*2));

        attribute.increase(amount);
        assertThat(attribute.getValue(), is(amount * 3));
    }

    @Test
    public void status_increaseAboveMax() {
        assertThat(attribute.getValue(), is(initialValue));
        Long amount = initialValue;

        attribute.increase(amount);
        assertThat(attribute.getValue(), is(100L));
    }

    @Test
    public void status_increaseNegativeArgument() {
        assertThat(attribute.getValue(), is(initialValue));
        try {
            attribute.increase(-1L);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Negative numbers are not accepted!"));
        }
    }
}
