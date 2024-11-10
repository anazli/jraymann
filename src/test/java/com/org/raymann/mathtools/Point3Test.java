package com.org.raymann.mathtools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3Test {
    private Point3 p;

    @BeforeEach
    void setUp() {
        p = Point3.create();
    }

    @Test
    public void givenNullPointWhenCreatedThenIsZeroInit() {
        assertEquals(0.f, p.x());
        assertEquals(0.f, p.y());
        assertEquals(0.f, p.z());
    }

    @Test
    public void givenFloatWhenSetsCoordinateThenItIsCorrectlyUpdated() {
        Float x = -0.5f;
        Float y = 14.4355f;
        Float z = -3.14159f;
        p.setX(x);
        p.setY(y);
        p.setZ(z);
        assertEquals(x, p.x());
        assertEquals(y, p.y());
        assertEquals(z, p.z());
    }

    @Test
    public void givenFloatWhenSetsAllCoordsThenTheyAreCorrectlyUpdated() {
        Float f = 3.14159f;
        p.setAll(f);
        assertEquals(f, p.x());
        assertEquals(f, p.y());
        assertEquals(f, p.z());
    }

    @Test
    public void givenTwoEqualPointsWhenTheyAreComparedThenReturnsTrue() {
        p = Point3.create(25.345f, 56.46f, 45.76f);
        Point3 p1 = Point3.create(25.345f, 56.46f, 45.76f);
        assertTrue(p.equals(p1));
        p.setX(924.55f);
        assertFalse(p.equals(p1));
    }

    @Test
    public void givenPointAndVectorWhenAddedThenResultedPointIsCorrect() {
        p.setAll(5.2f);
        Vec3 u = Vec3.create(3.14159f, -45.9f, 200.5346f);
        Point3 w = p.plus(u);
        assertEquals(8.34159f, w.x());
        assertEquals(-40.7f, w.y());
        assertEquals(205.7346f, w.z());
    }

    @Test
    public void givenTwoPointsWhenSubtractedThenResultedVectorIsCorrect() {
        p.setAll(5.2f);
        Point3 u = Point3.create(3.14159f, -45.9f, 200.5346f);
        Vec3 w = p.minus(u);
        assertEquals(2.0584097f, w.x());
        assertEquals(51.100002f, w.y());
        assertEquals(-195.33461f, w.z());
    }

    @Test
    public void givenPointsAndVectorWhenSubtractedThenResultedPointIsCorrect() {
        p.setAll(5.2f);
        Vec3 u = Vec3.create(3.14159f, -45.9f, 200.5346f);
        Point3 w = p.minus(u);
        assertEquals(2.0584097f, w.x());
        assertEquals(51.100002f, w.y());
        assertEquals(-195.33461f, w.z());
    }
}