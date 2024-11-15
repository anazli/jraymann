package com.org.raymann.composite;

import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector2D;
import com.org.raymann.mathtools.Vector3D;

public class Sphere implements SceneElement {
    private final Point3D center;
    private final float radius;

    public Sphere() {
        this(Point3D.create(), 1.f);
    }

    public Sphere(Point3D c, float r) {
        center = c;
        radius = r;
    }

    public static Sphere create() {
        return new Sphere();
    }

    public static Sphere create(Point3D c, float r) {
        return new Sphere(c, r);
    }

    public boolean intersect(Ray r, IntersectionRecord record) {
        Vector3D centerToOrigin = r.origin().minus(center);
        float a = r.direction().dot(r.direction());
        float b = 2.f * r.direction().dot(centerToOrigin);
        float c = centerToOrigin.dot(centerToOrigin) - radius * radius;
        float discriminant = b * b - 4.f * a * c;
        if (discriminant >= 0.f) {
            record.setFirstIntersection((float) (-b - Math.sqrt(discriminant)) / (2.f * a));
            record.setSecondIntersection((float) (-b + Math.sqrt(discriminant)) / (2.f * a));
            record.setTotalIntersections(2);
            return true;
        }
        return false;
    }

    public Vector3D normal(Point3D p) {
        return (p.minus(center)).normalVector();
    }
}
