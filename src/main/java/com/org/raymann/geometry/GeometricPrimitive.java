package com.org.raymann.geometry;

import com.org.raymann.acceleration.BoundingBox;
import com.org.raymann.composite.IntersectionRecord;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;

public abstract class GeometricPrimitive {
    private final BoundingBox boundingBox;

    public GeometricPrimitive(BoundingBox box) {
        boundingBox = box;
    }

    public abstract boolean intersect(Ray r, IntersectionRecord record);

    public abstract Vector3D normal(Point3D p);

    public static GeometricPrimitive create(PrimitiveType type,
                                            Object... args) {
        GeometricPrimitive primitive;
        switch (type) {
            case SPHERE:
                primitive = Sphere.create((Point3D) args[0], (float) args[1]);
            case PLANE:
                primitive = Plane.create();
            default:
                primitive = Sphere.create();//TODO:to be replaced by a default
        }
        return primitive;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
