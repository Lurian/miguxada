package com.example.model.tests.character.attribute.wit;

import com.example.model.character.attribute.wit.Wit;
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
public class WitTest extends AttributeTest {

    @Before
    public void setUp() {
        super.attribute = new Wit(super.initialValue);
        assertThat(super.attribute, is(notNullValue()));
    }
}
