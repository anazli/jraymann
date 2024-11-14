package com.org.raymann.composite;

public class IntersectionRecord {
    private float firstIntersection;
    private float secondIntersection;
    private int totalIntersections;

    public IntersectionRecord() {
        firstIntersection = secondIntersection = 0.f;
    }

    public static IntersectionRecord create() {
        return new IntersectionRecord();
    }

    public void setFirstIntersection(float t1) {
        firstIntersection = t1;
    }

    public float getFirstIntersection() {
        return firstIntersection;
    }

    public void setSecondIntersection(float t2) {
        secondIntersection = t2;
    }

    public float getSecondIntersection() {
        return secondIntersection;
    }

    public void setTotalIntersections(int n) {
        totalIntersections = n;
    }

    public int getTotalIntersections() {
        return totalIntersections;
    }
}
