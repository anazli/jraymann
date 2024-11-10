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
        float f = 0.f;
        assertEquals(f, v.x());
        assertEquals(f, v.y());
        assertEquals(f, v.z());
    }

    @Test
    public void givenFloatWhenSetsCoordinateThenItIsCorrectlyUpdated() {
        float x = -0.5f;
        float y = 14.4355f;
        float z = -3.14159f;
        v.setX(x);
        v.setY(y);
        v.setZ(z);
        assertEquals(x, v.x());
        assertEquals(y, v.y());
        assertEquals(z, v.z());
    }

    @Test
    public void givenFloatWhenSetsAllCoordsThenTheyAreCorrectlyUpdated() {
        float f = 3.14159f;
        v.setAll(f);
        assertEquals(f, v.x());
        assertEquals(f, v.y());
        assertEquals(f, v.z());
    }

    @Test
    public void givenNonNullVectorWhenLengthIsReturnedThenItIsCorrect() {
        assertEquals((float)Math.sqrt(0.f), v.length());
        v.setAll(-1.f);
        assertEquals((float)Math.sqrt(3.f), v.length());
        v.setAll(3.f);
        assertEquals((float)Math.sqrt(27.f), v.length());
    }

    @Test
    public void givenNonNullVectorWhenItIsNormalizedThenLengthIsCorrect() {
        v.setX(4.53f);
        v.setY(93.5f);
        v.setZ(-56.3f);
        v = v.normalVector();
        assertEquals(1.f, v.length());
    }

    @Test
    public void givenTwoVectorsWhenAddedThenResultedVectorIsCorrect() {
        v.setAll(5.2f);
        Vec3 u = Vec3.create(3.14159f, -45.9f, 200.5346f);
        Vec3 w = v.plus(u);
        assertEquals(8.34159f, w.x());
        assertEquals(-40.7f, w.y());
        assertEquals(205.7346f, w.z());
    }

    @Test
    public void givenTwoVectorsWhenSubtractedThenResultedVectorIsCorrect() {
        v.setAll(10.f);
        Vec3 u = Vec3.create(10.f, 10.f, 10.f);
        Vec3 w = v.minus(u);
        assertEquals(0.f, w.x());
        assertEquals(0.f, w.y());
        assertEquals(0.f, w.z());
    }

    @Test
    public void givenTwoVectorsWhenMultipliedThenResultedVectorIsCorrect() {
        v.setAll(9.325f);
        Vec3 u = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.times(u);
        assertEquals(85.78999f, w.x());
        assertEquals(-139.875f, w.y());
        assertEquals(69.9375f, w.z());
    }

    @Test
    public void givenVectorAndFloatWhenMultipliedThenResultedVectorIsCorrect() {
        Float f = 9.325f;
        v = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.times(f);
        assertEquals(85.78999f, w.x());
        assertEquals(-139.875f, w.y());
        assertEquals(69.9375f, w.z());
    }

    @Test
    public void givenTwoVectorsWhenDividedThenResultedVectorIsCorrect() {
        v.setAll(9.325f);
        Vec3 u = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.over(u);
        assertEquals(1.013587f, w.x());
        assertEquals(-0.62166667f, w.y());
        assertEquals(1.2433333f, w.z());
    }

    @Test
    public void givenVectorAndFloatWhenDividedThenResultedVectorIsCorrect() {
        Float f = 9.325f;
        v = Vec3.create(9.2f, -15.f, 7.5f);
        Vec3 w = v.over(f);
        assertEquals(0.98659515f, w.x());
        assertEquals(-1.6085792f, w.y());
        assertEquals(0.8042896f, w.z());
    }

    @Test
    public void givenTwoVectorsWhenDotIsComputedThenItIsCorrect() {
        v.setAll(3.14159f);
        Vec3 u = Vec3.create(9.2f, -15.f, 7.5f);
        assertEquals(5.340702f, v.dot(u));
    }

    @Test
    public void givenTwoVectorsWhenCrossIsComputedThenItIsCorrect() {
        v = Vec3.create(3.14159f,-0.4365f,73.456f);
        Vec3 u = Vec3.create(-55.5f,-84.25f,0.456f);
        Vec3 w = v.cross(u);
        assertEquals(6188.468956f, w.x());
        assertEquals(-4078.24076504f, w.y());
        assertEquals(-288.9047075f, w.z());
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