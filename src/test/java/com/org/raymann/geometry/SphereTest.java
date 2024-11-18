package com.org.raymann.geometry;

import com.org.raymann.composite.HitRecord;
import com.org.raymann.mathtools.Constants;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {
    private Sphere sphere;
    private HitRecord record;

    @BeforeEach
    void setUp() {
        record = HitRecord.create();
        sphere = Sphere.create();
    }

    @Test
    public void givenRayWhenIntersectsSphereThenTwoHitPointsAreCorrect() {
        Ray r = Ray.create(Point3D.create(0.f, 0.f, -5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalHitPoints());
        assertEquals(4.f, record.getFirstHitPoint());
        assertEquals(6.f, record.getSecondHitPoint());
    }

    @Test
    public void givenRayWhenIntersectsSphereThenTangentHitPointIsSame() {
        Ray r = Ray.create(Point3D.create(0.f, 1.f, -5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalHitPoints());
        assertEquals(5.f, record.getFirstHitPoint());
        assertEquals(5.f, record.getSecondHitPoint());
    }

    @Test
    public void givenRayWhenMissesSphereThenNoIntersectionOccurs() {
        Ray r = Ray.create(Point3D.create(0.f, 2.f, -5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertFalse(sphere.intersect(r, record));
        assertEquals(0, record.getTotalHitPoints());
    }

    @Test
    public void givenRayInsideSphereWhenIntersectsSphereThenFirstInterBehindOriAndSecondInFront() {
        Ray r = Ray.create(Point3D.create(0.f, 0.f, 0.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalHitPoints());
        assertEquals(-1.f, record.getFirstHitPoint());
        assertEquals(1.f, record.getSecondHitPoint());
    }

    @Test
    public void givenSphereBehindOriginWhenRayIntersectsSphereThenNegativeIntersectionsOccur() {
        Ray r = Ray.create(Point3D.create(0.f, 0.f, 5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalHitPoints());
        assertEquals(-6.f, record.getFirstHitPoint());
        assertEquals(-4.f, record.getSecondHitPoint());
    }

    @Test
    public void givenPointOnXAxisWhenNormalIsComputedThenResultIsCorrect() {
        Vector3D v = sphere.normal(Point3D.create(1.f, 0.f, 0.f));
        assertTrue(Vector3D.create(1.f, 0.f, 0.f).equals(v));
    }

    @Test
    public void givenPointOnYAxisWhenNormalIsComputedThenResultIsCorrect() {
        Vector3D v = sphere.normal(Point3D.create(0.f, 1.f, 0.f));
        assertTrue(Vector3D.create(0.f, 1.f, 0.f).equals(v));
    }

    @Test
    public void givenPointOnZAxisWhenNormalIsComputedThenResultIsCorrect() {
        Vector3D v = sphere.normal(Point3D.create(0.f, 0.f, 1.f));
        assertTrue(Vector3D.create(0.f, 0.f, 1.f).equals(v));
    }

    @Test
    public void givenNonAxialPointWhenNormalIsComputedThenResultIsCorrect() {
        float f = (float) Math.sqrt(3.f) / 3.f;
        Vector3D v = sphere.normal(Point3D.create(f, f, f));
        assertTrue(Vector3D.create(f, f, f).equals(v));
    }

    @Test
    public void givenAnyPointWhenNormalIsComputedThenItsLengthEqualsOne() {
        float f = (float) Math.sqrt(3.f) / 3.f;
        Vector3D v = sphere.normal(Point3D.create(f, f, f));
        assertEquals(1.f, v.length(), Constants.EPSILON);
    }

}