package com.example.model.tests.character.attribute.resilience;

import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.tests.character.attribute.AttributeTest;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test Class of Health, extends StatusTest
 *
 * @author Lucas Andrade
 */
public class ResilienceTest extends AttributeTest {

    @Before
    public void setUp() {
        super.attribute = new Resilience(super.initialValue);
        assertThat(super.attribute, is(notNullValue()));
    }
}
