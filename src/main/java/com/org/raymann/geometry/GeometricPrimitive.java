package com.org.raymann.geometry;

import com.org.raymann.acceleration.BoundingBox;
import com.org.raymann.composite.HitRecord;
import com.org.raymann.composite.SceneElement;
import com.org.raymann.materials.Material;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import com.org.raymann.renderers.Renderer;

public abstract class GeometricPrimitive implements SceneElement {
    private final BoundingBox boundingBox;
    private Material material = null;

    public GeometricPrimitive(BoundingBox box) {
        boundingBox = box;
    }

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

    public void add(SceneElement element) {

    }

    public boolean isWorld() {
        return false;
    }

    public void accept(Renderer renderer, Ray ray) {

    }

    public abstract boolean intersect(Ray r, HitRecord record);

    public abstract Vector3D normal(Point3D p);

    public void setMaterial(Material m) {
        material = m;
    }

    public Material getMaterial() {
        return material;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
