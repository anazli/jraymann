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
        assertEquals(1.6f, c3.red(), eps);
        assertEquals(0.7f, c3.green(), eps);
        assertEquals(1.f, c3.blue(), eps);
    }

    @Test
    public void givenTwoColorsWhenSubtractedThenCorrectColorIsReturned() {
        Color c1 = Color.create(0.9f, 0.6f, 0.75f);
        Color c2 = Color.create(0.7f, 0.1f, 0.25f);
        Color c3 = c1.minus(c2);
        assertEquals(0.2f, c3.red(), eps);
        assertEquals(0.5f, c3.green(), eps);
        assertEquals(0.5f, c3.blue(), eps);
    }

    @Test
    public void givenColorAndFloatWhenMultipliedThenCorrectColorIsReturned() {
        Color c = Color.create(0.2f, 0.3f, 0.4f);
        c = c.times(2.f);
        assertEquals(0.4f, c.red(), eps);
        assertEquals(0.6f, c.green(), eps);
        assertEquals(0.8f, c.blue(), eps);
    }

    @Test
    public void givenTwoColorsWhenMultipliedThenCorrectColorIsReturned() {
        Color c1 = Color.create(1.f, 0.2f, 0.4f);
        Color c2 = Color.create(0.9f, 1.f, 0.1f);
        Color c3 = c1.times(c2);
        assertEquals(0.9f, c3.red(), eps);
        assertEquals(0.2f, c3.green(), eps);
        assertEquals(0.04f, c3.blue(), eps);
    }

}