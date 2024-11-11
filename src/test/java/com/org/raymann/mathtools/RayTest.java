package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {
    private Ray r;

    @Test
    public void givenNullRayWhenItIsCreatedThenItIsCorrect() {
        Point3D o = Point3D.create();
        Vector3D d = Vector3D.create();
        r = Ray.create();
        assertTrue(o.equals(r.origin()));
        assertTrue(d.equals(r.direction()));

        o = Point3D.create(1.f, 2.f, 3.f);
        d = Vector3D.create(4.f, 5.f, 6.f);
        r = Ray.create(o, d);
        assertTrue(o.equals(r.origin()));
        assertTrue(d.equals(r.direction()));
    }

    @Test
    public void givenNotNullRayWhenPositionIsComputedThenItIsCorrect() {
        Point3D o = Point3D.create(2.f, 3.f, 4.f);
        Vector3D d = Vector3D.create(1.f, 0.f, 0.f);
        r = Ray.create(o, d);
        Point3D p = Point3D.create(o);

        assertTrue(p.equals(r.position(0.f)));
        p = Point3D.create(3.f, 3.f, 4.f);
        assertTrue(p.equals(r.position(1.f)));
        p = Point3D.create(1.f, 3.f, 4.f);
        assertTrue(p.equals(r.position(-1.f)));
        p = Point3D.create(4.5f, 3.f, 4.f);
        assertTrue(p.equals(r.position(2.5f)));
    }

}