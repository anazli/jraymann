package com.org.raymann.composite;

import com.org.raymann.materials.Material;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;

public interface SceneElement {
    boolean intersect(Ray r, HitRecord record);

    Vector3D normal(Point3D p);
}
