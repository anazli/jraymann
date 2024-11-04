package com.org.raymann.mathtools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3Test {
    private Point3 p;

    @BeforeEach
    void setUp() {
        p = new Point3();
    }

    @Test
    public void givenNullPointWhenCreatedThenIsZeroInit() {
        assertEquals(p.x(), 0.f);
        assertEquals(p.y(), 0.f);
        assertEquals(p.z(), 0.f);
    }

    @Test
    public void givenFloatWhenSetsCoordinateThenItIsCorrectlyUpdated() {
        Float x = -0.5f;
        Float y = 14.4355f;
        Float z = -3.14159f;
        p.setX(x);
        p.setY(y);
        p.setZ(z);
        assertEquals(p.x(), x);
        assertEquals(p.y(), y);
        assertEquals(p.z(), z);
    }

    @Test
    public void givenFloatWhenSetsAllCoordsThenTheyAreCorrectlyUpdated() {
        Float f = 3.14159f;
        p.setAll(f);
        assertEquals(p.x(), f);
        assertEquals(p.y(), f);
        assertEquals(p.z(), f);
    }

    @Test
    public void givenTwoEqualPointsWhenTheyAreComparedThenReturnsTrue() {
        p = new Point3(25.345f, 56.46f, 45.76f);
        Point3 p1 = new Point3(25.345f, 56.46f, 45.76f);
        assertTrue(p.equals(p1));
        p.setX(924.55f);
        assertFalse(p.equals(p1));
    }

    @Test
    public void givenPointAndVectorWhenAddedThenResultedPointIsCorrect() {
        p.setAll(5.2f);
        Vec3 u = new Vec3(3.14159f, -45.9f, 200.5346f);
        Point3 w = p.plus(u);
        assertEquals(w.x(), 8.34159f);
        assertEquals(w.y(), -40.7f);
        assertEquals(w.z(), 205.7346f);
    }

    @Test
    public void givenTwoPointsWhenSubtractedThenResultedVectorIsCorrect() {
        p.setAll(5.2f);
        Point3 u = new Point3(3.14159f, -45.9f, 200.5346f);
        Vec3 w = p.minus(u);
        assertEquals(w.x(), 2.0584097f);
        assertEquals(w.y(), 51.100002f);
        assertEquals(w.z(), -195.33461f);
    }

    @Test
    public void givenPointsAndVectorWhenSubtractedThenResultedPointIsCorrect() {
        p.setAll(5.2f);
        Vec3 u = new Vec3(3.14159f, -45.9f, 200.5346f);
        Point3 w = p.minus(u);
        assertEquals(w.x(), 2.0584097f);
        assertEquals(w.y(), 51.100002f);
        assertEquals(w.z(), -195.33461f);
    }
}