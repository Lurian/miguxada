package com.example.model.tests.character.attribute.agility;

import com.example.model.character.attribute.agility.Agility;
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
public class AgilityTest extends AttributeTest {

    @Before
    public void setUp() {
        super.attribute = new Agility(super.initialValue);
        assertThat(super.attribute, is(notNullValue()));
    }
}
