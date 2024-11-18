package com.org.raymann.composite;

import com.org.raymann.acceleration.BoundingBox;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;

public interface SceneElement {
    BoundingBox getBoundingBox();

    boolean intersect(Ray r, IntersectionRecord record);

    Vector3D normal(Point3D p);
}
