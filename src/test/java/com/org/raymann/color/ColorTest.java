package com.org.raymann.color;

import com.org.raymann.mathtools.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    private static final Float eps = Constants.EPSILON;

    @Test
    public void givenTwoColorsWhenAddedThenCorrectColorIsReturned() {
        Color c1 = Color.create(0.9f, 0.6f, 0.75f);
        Color c2 = Color.create(0.7f, 0.1f, 0.25f);
        Color c3 = c1.plus(c2);
        assertTrue(Math.abs(c3.red() - 1.6f) < eps);
        assertTrue(Math.abs(c3.green() - 0.7f) < eps);
        assertTrue(Math.abs(c3.blue() - 1.0f) < eps);
    }
    @Test
    public void givenTwoColorsWhenSubtractedThenCorrectColorIsReturned() {
        Color c1 = Color.create(0.9f, 0.6f, 0.75f);
        Color c2 = Color.create(0.7f, 0.1f, 0.25f);
        Color c3 = c1.minus(c2);
        assertTrue(Math.abs(c3.red() - 0.2f) < eps);
        assertTrue(Math.abs(c3.green() - 0.5f) < eps);
        assertTrue(Math.abs(c3.blue() - 0.5f) < eps);
    }

    @Test
    public void givenColorAndFloatWhenMultipliedThenCorrectColorIsReturned() {
        Color c = Color.create(0.2f, 0.3f, 0.4f);
        c = c.times(2.f);
        assertTrue(Math.abs(c.red() - 0.4f) < eps);
        assertTrue(Math.abs(c.green() - 0.6f) < eps);
        assertTrue(Math.abs(c.blue() - 0.8f) < eps);
    }

    @Test
    public void givenTwoColorsWhenMultipliedThenCorrectColorIsReturned() {
        Color c1 = Color.create(1.f, 0.2f, 0.4f);
        Color c2 = Color.create(0.9f, 1.f, 0.1f);
        Color c3 = c1.times(c2);
        assertTrue(Math.abs(c3.red() - 0.9f) < eps);
        assertTrue(Math.abs(c3.green() - 0.2f) < eps);
        assertTrue(Math.abs(c3.blue() - 0.04f) < eps);
    }

}