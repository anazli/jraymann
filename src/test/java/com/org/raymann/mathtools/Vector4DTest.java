package com.org.raymann.mathtools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Vector4DTest {
    private Vector4D v;

    @BeforeEach
    void setUp() {
        v = Vector4D.create();
    }

    @Test
    public void givenNullVectorWhenItIsCreatedThenItIsZeroInit() {
        float f = 0.f;
        assertEquals(f, v.x());
        assertEquals(f, v.y());
        assertEquals(f, v.z());
        assertEquals(f, v.w());
    }

    @Test
    public void givenFloatWhenSetsCoordinateThenItIsCorrectlyUpdated() {
        float x = -0.5f;
        float y = 14.4355f;
        float z = -3.14159f;
        float w = 99.9f;
        v.setX(x);
        v.setY(y);
        v.setZ(z);
        v.setW(w);
        assertEquals(x, v.x());
        assertEquals(y, v.y());
        assertEquals(z, v.z());
        assertEquals(w, v.w());
    }

    @Test
    public void givenFloatWhenSetsAllCoordsThenTheyAreCorrectlyUpdated() {
        float f = 3.14159f;
        v.setAll(f);
        assertEquals(f, v.x());
        assertEquals(f, v.y());
        assertEquals(f, v.z());
        assertEquals(f, v.w());
    }

    @Test
    public void givenNonNullVectorWhenLengthIsReturnedThenItIsCorrect() {
        assertEquals((float)Math.sqrt(0.f), v.length());
        v.setAll(-1.f);
        assertEquals((float)Math.sqrt(4.f), v.length());
        v.setAll(3.f);
        assertEquals((float)Math.sqrt(36.f), v.length());
    }

    @Test
    public void givenNonNullVectorWhenItIsNormalizedThenLengthIsCorrect() {
        v.setX(4.53f);
        v.setY(93.5f);
        v.setZ(-56.3f);
        v.setW(3.14f);
        v = v.normalVector();
        assertEquals(1.f, v.length());
    }

    @Test
    public void givenTwoVectorsWhenAddedThenResultedVectorIsCorrect() {
        v.setAll(5.2f);
        Vector4D u = Vector4D.create(3.14159f, -45.9f, 200.5346f, 0.34f);
        Vector4D w = v.plus(u);
        assertEquals(8.34159f, w.x());
        assertEquals(-40.7f, w.y());
        assertEquals(205.7346f, w.z());
        assertEquals(5.54f, w.w());
    }

    @Test
    public void givenTwoVectorsWhenSubtractedThenResultedVectorIsCorrect() {
        v.setAll(10.f);
        Vector4D u = Vector4D.create(10.f, 10.f, 10.f, 10.f);
        Vector4D w = v.minus(u);
        assertEquals(0.f, w.x());
        assertEquals(0.f, w.y());
        assertEquals(0.f, w.z());
        assertEquals(0.f, w.w());
    }

    @Test
    public void givenTwoVectorsWhenMultipliedThenResultedVectorIsCorrect() {
        v.setAll(9.325f);
        Vector4D u = Vector4D.create(9.2f, -15.f, 7.5f, 1.f);
        Vector4D w = v.times(u);
        assertEquals(85.78999f, w.x());
        assertEquals(-139.875f, w.y());
        assertEquals(69.9375f, w.z());
        assertEquals(9.325f, w.w());
    }

    @Test
    public void givenVectorAndFloatWhenMultipliedThenResultedVectorIsCorrect() {
        float f = 9.325f;
        v = Vector4D.create(9.2f, -15.f, 7.5f, 0.f);
        Vector4D w = v.times(f);
        assertEquals(85.78999f, w.x());
        assertEquals(-139.875f, w.y());
        assertEquals(69.9375f, w.z());
        assertEquals(0.f, w.w());
    }

    @Test
    public void givenTwoVectorsWhenDividedThenResultedVectorIsCorrect() {
        v.setAll(9.325f);
        Vector4D u = Vector4D.create(9.2f, -15.f, 7.5f, 1.f);
        Vector4D w = v.over(u);
        assertEquals(1.013587f, w.x());
        assertEquals(-0.62166667f, w.y());
        assertEquals(1.2433333f, w.z());
        assertEquals(9.325f, w.w());
    }

    @Test
    public void givenVectorAndFloatWhenDividedThenResultedVectorIsCorrect() {
        float f = 9.325f;
        v = Vector4D.create(9.2f, -15.f, 7.5f, 0.f);
        Vector4D w = v.over(f);
        assertEquals(0.98659515f, w.x());
        assertEquals(-1.6085792f, w.y());
        assertEquals(0.8042896f, w.z());
        assertEquals(0.f, w.w());
    }

    @Test
    public void givenTwoVectorsWhenDotIsComputedThenItIsCorrect() {
        v.setAll(3.14159f);
        Vector4D u = Vector4D.create(9.2f, -15.f, 7.5f, 0.f);
        assertEquals(5.340702f, v.dot(u));
    }

    @Test
    public void givenTwoEqualVectorsWhenTheyAreComparedThenReturnsTrue() {
        v.setX(1.f);
        v.setY(2.f);
        v.setZ(3.f);
        v.setW(0.f);
        Vector4D u = Vector4D.create(1.f, 2.f, 3.f, 0.f);
        assertTrue(v.equals(u));
        v.setAll(5.f);
        assertFalse(v.equals(u));
    }

    @Test
    public void givenNonNullVectorWhenNegatedThenReturnsOpposite() {
        v.setAll(43.87f);
        Vector4D u = v.opposite();
        assertEquals(-v.x(), u.x());
        assertEquals(-v.y(), u.y());
        assertEquals(-v.z(), u.z());
        assertEquals(-v.w(), u.w());
    }
}