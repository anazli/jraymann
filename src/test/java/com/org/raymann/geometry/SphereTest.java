package com.org.raymann.geometry;

import com.org.raymann.composite.IntersectionRecord;
import com.org.raymann.mathtools.Constants;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {
    private Sphere sphere;
    private IntersectionRecord record;

    @BeforeEach
    void setUp() {
        record = IntersectionRecord.create();
        sphere = Sphere.create();
    }

    @Test
    public void givenRayWhenIntersectsSphereThenTwoHitPointsAreCorrect() {
        Ray r = Ray.create(Point3D.create(0.f, 0.f, -5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalIntersections());
        assertEquals(4.f, record.getFirstIntersection());
        assertEquals(6.f, record.getSecondIntersection());
    }

    @Test
    public void givenRayWhenIntersectsSphereThenTangentHitPointIsSame() {
        Ray r = Ray.create(Point3D.create(0.f, 1.f, -5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalIntersections());
        assertEquals(5.f, record.getFirstIntersection());
        assertEquals(5.f, record.getSecondIntersection());
    }

    @Test
    public void givenRayWhenMissesSphereThenNoIntersectionOccurs() {
        Ray r = Ray.create(Point3D.create(0.f, 2.f, -5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertFalse(sphere.intersect(r, record));
        assertEquals(0, record.getTotalIntersections());
    }

    @Test
    public void givenRayInsideSphereWhenIntersectsSphereThenFirstInterBehindOriAndSecondInFront() {
        Ray r = Ray.create(Point3D.create(0.f, 0.f, 0.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalIntersections());
        assertEquals(-1.f, record.getFirstIntersection());
        assertEquals(1.f, record.getSecondIntersection());
    }

    @Test
    public void givenSphereBehindOriginWhenRayIntersectsSphereThenNegativeIntersectionsOccur() {
        Ray r = Ray.create(Point3D.create(0.f, 0.f, 5.f), Vector3D.create(0.f, 0.f, 1.f));
        assertTrue(sphere.intersect(r, record));
        assertEquals(2, record.getTotalIntersections());
        assertEquals(-6.f, record.getFirstIntersection());
        assertEquals(-4.f, record.getSecondIntersection());
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