package com.org.raymann.composite;

import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import com.org.raymann.renderers.Renderer;

import java.util.ArrayList;

public class World implements SceneElement{
    ArrayList<SceneElement> elements;
    HitRecord hitRecord;

    public World() {
        elements = new ArrayList<>();
        hitRecord = HitRecord.create();
    }

    public void add(SceneElement element) {
        elements.add(element);
    }

    public boolean isWorld() {
        return true;
    }

    public void accept(Renderer renderer, Ray ray) {

    }

    public boolean intersect(Ray r, HitRecord record) {
        boolean hitFound = false;
        for(SceneElement element : elements) {
            hitFound = element.intersect(r, record);
        }
        return hitFound;
    }

    public Vector3D normal(Point3D p) {
        return hitRecord.getHitElement().normal(p);
    }
}
