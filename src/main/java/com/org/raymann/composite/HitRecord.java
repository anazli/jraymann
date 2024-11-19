package com.org.raymann.composite;

import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;

public class HitRecord {
    private float firstHitPoint;
    private float secondHitPoint;
    private int totalHitPoints;
    private Ray scatteredRay;
    private Vector3D normalAtHitPoint;

    public HitRecord() {
        firstHitPoint = secondHitPoint = 0.f;
    }

    public static HitRecord create() {
        return new HitRecord();
    }

    public void setFirstHitPoint(float t1) {
        firstHitPoint = t1;
    }

    public float getFirstHitPoint() {
        return firstHitPoint;
    }

    public void setSecondHitPoint(float t2) {
        secondHitPoint = t2;
    }

    public float getSecondHitPoint() {
        return secondHitPoint;
    }

    public void setTotalHitPoints(int n) {
        totalHitPoints = n;
    }

    public int getTotalHitPoints() {
        return totalHitPoints;
    }

    public float getMinPositiveHitPoint() {
        if (firstHitPoint > 0.f && secondHitPoint <= 0.f) {
            return firstHitPoint;
        } else if (firstHitPoint <= 0.f && secondHitPoint > 0.f) {
            return secondHitPoint;
        } else if (firstHitPoint > 0.f && secondHitPoint > 0.f) {
            return Math.min(firstHitPoint, secondHitPoint);
        }
        return -1.f;
    }

    public Point3D hitPoint(Ray ray) {
        return ray.position(getMinPositiveHitPoint());
    }

    public void setScatteredRay(Ray ray) {
        scatteredRay = ray;
    }

    public Ray getScatteredRay() {
        return scatteredRay;
    }

    public void setNormalAtHitPoint(Vector3D n) {
        normalAtHitPoint = n;
    }

    public Vector3D getNormalAtHitPoint() {
        return normalAtHitPoint;
    }
}
