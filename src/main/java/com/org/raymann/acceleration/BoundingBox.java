package com.org.raymann.acceleration;

import com.org.raymann.mathtools.Constants;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;

public class BoundingBox {
    private Point3D minPoint = Point3D.create(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private Point3D maxPoint = Point3D.create(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public BoundingBox() {
    }

    public BoundingBox(Point3D pMin, Point3D pMax) {
        minPoint = pMin;
        maxPoint = pMax;
    }

    public static BoundingBox create() {
        return new BoundingBox();
    }

    public static BoundingBox create(Point3D pMin, Point3D pMax) {
        return new BoundingBox(pMin, pMax);
    }

    public void addPoint(Point3D point) {
        if (point.x() < minPoint.x()) minPoint.setX(point.x());
        if (point.y() < minPoint.y()) minPoint.setY(point.y());
        if (point.z() < minPoint.z()) minPoint.setZ(point.z());

        if (point.x() > maxPoint.x()) maxPoint.setX(point.x());
        if (point.y() > maxPoint.y()) maxPoint.setY(point.y());
        if (point.z() > maxPoint.z()) maxPoint.setZ(point.z());
    }

    public void addBox(BoundingBox box) {
        addPoint(box.minPoint);
        addPoint(box.maxPoint);
    }

    public boolean containsPoint(Point3D point) {
        return point.x() >= minPoint.x() && point.x() <= maxPoint.x() &&
                point.y() >= minPoint.y() && point.y() <= maxPoint.y() &&
                point.z() >= minPoint.z() && point.z() <= maxPoint.z();
    }

    public boolean containsBoundingBox(BoundingBox box) {
        return containsPoint(box.minPoint) && containsPoint(box.maxPoint);
    }

    public boolean intersectsRay(Ray r) {
        float[] xMinMax = hitAxis(r.origin().x(), r.direction().x(),
                minPoint.x(), maxPoint.x());
        float[] yMinMax = hitAxis(r.origin().y(), r.direction().y(),
                minPoint.y(), maxPoint.y());
        float[] zMinMax = hitAxis(r.origin().z(), r.direction().z(),
                minPoint.z(), maxPoint.z());
        float tMin = Math.max(Math.max(xMinMax[0], yMinMax[0]), zMinMax[0]);
        float tMax =
                Math.min(Math.min(xMinMax[1], yMinMax[1]), zMinMax[1]);
        return !(tMin > tMax);
    }

    private float[] hitAxis(float origin, float direction, float min, float max) {
        float tMinNumerator = (min - origin);
        float tMaxNumerator = (max - origin);
        float tMin, tMax;
        if (Math.abs(direction) >= Constants.EPSILON) {
            tMin = tMinNumerator / direction;
            tMax = tMaxNumerator / direction;
        } else {
            tMin = tMinNumerator * Float.POSITIVE_INFINITY;
            tMax = tMaxNumerator * Float.POSITIVE_INFINITY;
        }
        if (tMin > tMax) {
            float temp = tMin;
            tMin = tMax;
            tMax = temp;
        }
        return new float[]{tMin, tMax};
    }

}
