package com.example.model.tests.character.attribute.stamina;

import com.example.model.character.attribute.stamina.Stamina;
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
public class StaminaTest extends AttributeTest {

    @Before
    public void setUp() {
        super.attribute = new Stamina(super.initialValue);
        assertThat(super.attribute, is(notNullValue()));
    }
}
