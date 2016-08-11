package com.example.model.tests.character.attribute.resolve;

import com.example.model.character.attribute.resolve.Resolve;
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
public class ResolveTest extends AttributeTest {

    @Before
    public void setUp() {
        super.attribute = new Resolve(super.initialValue);
        assertThat(super.attribute, is(notNullValue()));
    }
}
