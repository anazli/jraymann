package com.org.raymann.mathtools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Vec3Test {
    private Vec3 v;

    @BeforeEach
    void setUp() {
        v = new Vec3();
    }

    @Test
    public void givenNullVectorWhenItIsCreatedThenItIsZeroInit() {
        assertEquals(v.x(), 0.f);
        assertEquals(v.y(), 0.f);
        assertEquals(v.z(), 0.f);
    }

    @Test
    public void givenFloatWhenSetsCoordinateThenItIsCorrectlyUpdated() {
        Float x = -0.5f;
        Float y = 14.4355f;
        Float z = -3.14159f;
        v.setX(x);
        v.setY(y);
        v.setZ(z);
        assertEquals(v.x(), x);
        assertEquals(v.y(), y);
        assertEquals(v.z(), z);
    }

    @Test
    public void givenFloatWhenSetsAllCoordsThenTheyAreCorrectlyUpdated() {
        Float f = 3.14159f;
        v.setAll(f);
        assertEquals(v.x(), f);
        assertEquals(v.y(), f);
        assertEquals(v.z(), f);
    }

    @Test
    public void givenNonNullVectorWhenLengthIsReturnedThenItIsCorrect() {
        assertEquals(v.length(), ((Double)Math.sqrt(0.f)).floatValue());
        v.setAll(-1.f);
        assertEquals(v.length(), ((Double)Math.sqrt(3.f)).floatValue());
        v.setAll(3.f);
        assertEquals(v.length(), ((Double)Math.sqrt(27.f)).floatValue());
    }

    @Test
    public void givenNonNullVectorWhenItIsNormalizedThenLengthIsCorrect() {
        v.setX(4.53f);
        v.setY(93.5f);
        v.setZ(-56.3f);
        v = v.normalVector();
        assertEquals(v.length(), 1.f);
    }
}