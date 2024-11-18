package com.org.raymann.geometry;

import com.org.raymann.composite.IntersectionRecord;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    private Plane plane;

    @BeforeEach
    public void setUp() {
        plane = Plane.create();
    }

    @Test
    public void givenPlaneWhenNormalIsComputedThenItIsConstant() {
        Vector3D n1 = plane.normal(Point3D.create(0.f, 0.f, 0.f));
        Vector3D n2 = plane.normal(Point3D.create(10.f, 0.f, -10.f));
        Vector3D n3 = plane.normal(Point3D.create(-5.f, 0.f, 150.f));
        assertTrue(Vector3D.create(0.f, 1.f, 0.f).equals(n1));
        assertTrue(Vector3D.create(0.f, 1.f, 0.f).equals(n2));
        assertTrue(Vector3D.create(0.f, 1.f, 0.f).equals(n3));
    }

    @Test
    public void givenPlaneParallelToRayWhenIntersectionIsTestedThenNoPointsAreFound() {
        IntersectionRecord record = IntersectionRecord.create();
        Ray r = Ray.create(Point3D.create(0.f, 10.f, 0.f), Vector3D.create(0.f, 0.f, 1.f));
        assertFalse(plane.intersect(r, record));
        assertEquals(0, record.getTotalIntersections());
    }

    @Test
    public void givenCoPlanarRayWhenIntersectionIsTestedThenNoPointsAreFound() {
        IntersectionRecord record = IntersectionRecord.create();
        Ray r = Ray.create(Point3D.create(0.f, 0.f, 0.f), Vector3D.create(0.f, 0.f, 1.f));
        assertFalse(plane.intersect(r, record));
        assertEquals(0, record.getTotalIntersections());
    }

    @Test
    public void givenRayAbovePlaneWhenIntersectionIsTestedThenPointIsFound() {
        IntersectionRecord record = IntersectionRecord.create();
        Ray r = Ray.create(Point3D.create(0.f, 1.f, 0.f), Vector3D.create(0.f, -1.f, 0.f));
        assertTrue(plane.intersect(r, record));
        assertEquals(1, record.getTotalIntersections());
        assertEquals(1.f, record.getMinPositiveIntersection());
    }

    @Test
    public void givenRayBelowPlaneWhenIntersectionIsTestedThenPointIsFound() {
        IntersectionRecord record = IntersectionRecord.create();
        Ray r = Ray.create(Point3D.create(0.f, -1.f, 0.f), Vector3D.create(0.f, 1.f, 0.f));
        assertTrue(plane.intersect(r, record));
        assertEquals(1, record.getTotalIntersections());
        assertEquals(1.f, record.getMinPositiveIntersection());
    }

}