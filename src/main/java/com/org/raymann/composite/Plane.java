package com.org.raymann.composite;

import com.org.raymann.mathtools.Constants;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;

public class Plane implements SceneElement{

    public static Plane create() {
        return new Plane();
    }

    public boolean intersect(Ray r, IntersectionRecord record) {
        if(Math.abs(r.direction().y()) < Constants.EPSILON) {
            return false;
        }
        record.setFirstIntersection(-r.origin().y()/r.direction().y());
        record.setTotalIntersections(1);
        return true;
    }

    public Vector3D normal(Point3D p) {
        return Vector3D.create(0.f, 1.f, 0.f);
    }

}
