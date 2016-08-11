package com.example.model.tests.character.attribute.resilence;

import com.example.model.character.attribute.resilence.Resilence;
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
public class ResilenceTest extends AttributeTest {

    @Before
    public void setUp() {
        super.attribute = new Resilence(super.initialValue);
        assertThat(super.attribute, is(notNullValue()));
    }
}
