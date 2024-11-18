package com.org.raymann.composite;

public class HitRecord {
    private float firstHitPoint;
    private float secondHitPoint;
    private int totalHitPoints;

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
}
