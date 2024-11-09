package com.org.raymann.mathtools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vec3Test {
    private Vec3 v;

    @BeforeEach
    void setUp() {
        v = Vec3.create();
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
        assertEquals(v.length(), (float)Math.sqrt(0.f));
        v.setAll(-1.f);
        assertEquals(v.length(), (float)Math.sqrt(3.f));
        v.setAll(3.f);
        assertEquals(v.length(), (float)Math.sqrt(27.f));
    }

    @Test
    public void givenNonNullVectorWhenItIsNormalizedThenLengthIsCorrect() {
        v.setX(4.53f);
        v.setY(93.5f);
        v.setZ(-56.3f);
        v = v.normalVector();
        assertEquals(v.length(), 1.f);
    }

    @Test
    public void givenTwoVectorsWhenAddedThenResultedVectorIsCorrect() {
        v.setAll(5.2f);
        Vec3 u = Vec3.create(3.14159f, -45.9f, 200.5346f);
        Vec3 w = v.plus(u);
        assertEquals(w.x(), 8.34159f);
        assertEquals(w.y(), -40.7f);
        assertEquals(w.z(), 205.7346f);
    }

    @Test
    public void givenTwoVectorsWhenSubtractedThenResultedVectorIsCorrect() {
        v.setAll(10.f);
        Vec3 u = Vec3.create(10.f, 10.f, 10.f);
        Vec3 w = v.minus(u);
        assertEquals(w.x(), 0.f);
        assertEquals(w.y(), 0.f);
        assertEquals(w.z(), 0.f);
    }

    @Test
    public void givenTwoVectorsWhenMultipliedThenResultedVectorIsCorrect() {
        v.setAll(9.325f);
        Vec3 u = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.times(u);
        assertEquals(w.x(), 85.78999f);
        assertEquals(w.y(), -139.875f);
        assertEquals(w.z(), 69.9375f);
    }

    @Test
    public void givenVectorAndFloatWhenMultipliedThenResultedVectorIsCorrect() {
        Float f = 9.325f;
        v = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.times(f);
        assertEquals(w.x(), 85.78999f);
        assertEquals(w.y(), -139.875f);
        assertEquals(w.z(), 69.9375f);
    }

    @Test
    public void givenTwoVectorsWhenDividedThenResultedVectorIsCorrect() {
        v.setAll(9.325f);
        Vec3 u = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.over(u);
        assertEquals(w.x(), 1.013587f);
        assertEquals(w.y(), -0.62166667f);
        assertEquals(w.z(), 1.2433333f);
    }

    @Test
    public void givenVectorAndFloatWhenDividedThenResultedVectorIsCorrect() {
        Float f = 9.325f;
        v = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.over(f);
        assertEquals(w.x(), 0.98659515f);
        assertEquals(w.y(), -1.6085792f);
        assertEquals(w.z(), 0.8042896f);
    }

    @Test
    public void givenTwoVectorsWhenDotIsComputedThenItIsCorrect() {
        v.setAll(3.14159f);
        Vec3 u = Vec3.create(9.2f, -15.f, 7.5f);
        assertEquals(v.dot(u), 5.340702f);
    }

    @Test
    public void givenTwoVectorsWhenCrossIsComputedThenItIsCorrect() {
        v = Vec3.create(3.14159f,-0.4365f,73.456f);
        Vec3 u = Vec3.create(-55.5f,-84.25f,0.456f);
        Vec3 w = v.cross(u);
        assertEquals(w.x(), 6188.468956f);
        assertEquals(w.y(), -4078.24076504f);
        assertEquals(w.z(), -288.9047075f);
    }

    @Test
    public void givenTwoEqualVectorsWhenTheyAreComparedThenReturnsTrue() {
        v.setX(1.f);
        v.setY(2.f);
        v.setZ(3.f);
        Vec3 u = Vec3.create(1.f, 2.f, 3.f);
        assertTrue(v.equals(u));
        v.setAll(5.f);
        assertFalse(v.equals(u));
    }

    @Test
    public void givenNonNullVectorWhenNegatedThenReturnsOpposite() {
        v.setAll(43.87f);
        Vec3 u = v.opposite();
        assertEquals(-v.x(), u.x());
        assertEquals(-v.y(), u.y());
        assertEquals(-v.z(), u.z());
    }
}