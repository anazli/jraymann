package com.org.raymann.composite;

import com.org.raymann.materials.Material;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import com.org.raymann.renderers.Renderer;

public interface SceneElement {
    void add(SceneElement element);
    boolean isWorld();
    void accept(Renderer renderer, Ray ray);
    boolean intersect(Ray r, HitRecord record);

    Vector3D normal(Point3D p);
}
