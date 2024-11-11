package com.org.raymann.mathtools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Point3DTest {
    private Point3D p;

    @BeforeEach
    void setUp() {
        p = Point3D.create();
    }

    @Test
    public void givenNullPointWhenCreatedThenIsZeroInit() {
        assertEquals(0.f, p.x());
        assertEquals(0.f, p.y());
        assertEquals(0.f, p.z());
    }

    @Test
    public void givenFloatWhenSetsCoordinateThenItIsCorrectlyUpdated() {
        float x = -0.5f;
        float y = 14.4355f;
        float z = -3.14159f;
        p.setX(x);
        p.setY(y);
        p.setZ(z);
        assertEquals(x, p.x());
        assertEquals(y, p.y());
        assertEquals(z, p.z());
    }

    @Test
    public void givenFloatWhenSetsAllCoordsThenTheyAreCorrectlyUpdated() {
        float f = 3.14159f;
        p.setAll(f);
        assertEquals(f, p.x());
        assertEquals(f, p.y());
        assertEquals(f, p.z());
    }

    @Test
    public void givenTwoEqualPointsWhenTheyAreComparedThenReturnsTrue() {
        p = Point3D.create(25.345f, 56.46f, 45.76f);
        Point3D p1 = Point3D.create(25.345f, 56.46f, 45.76f);
        assertTrue(p.equals(p1));
        p.setX(924.55f);
        assertFalse(p.equals(p1));
    }

    @Test
    public void givenPointAndVectorWhenAddedThenResultedPointIsCorrect() {
        p.setAll(5.2f);
        Vector3D u = Vector3D.create(3.14159f, -45.9f, 200.5346f);
        Point3D w = p.plus(u);
        assertEquals(8.34159f, w.x());
        assertEquals(-40.7f, w.y());
        assertEquals(205.7346f, w.z());
    }

    @Test
    public void givenTwoPointsWhenSubtractedThenResultedVectorIsCorrect() {
        p.setAll(5.2f);
        Point3D u = Point3D.create(3.14159f, -45.9f, 200.5346f);
        Vector3D w = p.minus(u);
        assertEquals(2.0584097f, w.x());
        assertEquals(51.100002f, w.y());
        assertEquals(-195.33461f, w.z());
    }

    @Test
    public void givenPointsAndVectorWhenSubtractedThenResultedPointIsCorrect() {
        p.setAll(5.2f);
        Vector3D u = Vector3D.create(3.14159f, -45.9f, 200.5346f);
        Point3D w = p.minus(u);
        assertEquals(2.0584097f, w.x());
        assertEquals(51.100002f, w.y());
        assertEquals(-195.33461f, w.z());
    }
}