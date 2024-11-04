package com.org.raymann.mathtools;

public class Point3 {
    private Float x;
    private Float y;
    private Float z;

    public Point3() {
        this(0.f, 0.f, 0.f);
    }

    public Point3(Float x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public void setZ(Float z) {
        this.z = z;
    }

    public void setAll(Float f) {
        x = y = z = f;
    }

    public Float x() {
        return x;
    }

    public Float y() {
        return y;
    }

    public Float z() {
        return z;
    }

    public boolean equals(Point3 p) {
        return (Math.abs(x - p.x()) < Constants.EPSILON) &&
                (Math.abs(y - p.y()) < Constants.EPSILON) &&
                (Math.abs(z - p.z()) < Constants.EPSILON);
    }

    public Point3 plus(Vec3 v) {
        return new Point3(x + v.x(), y + v.y(), z + v.z());
    }

    public Vec3 minus(Point3 p) {
        return new Vec3(x - p.x(), y - p.y(), z - p.z());
    }

    public Point3 minus(Vec3 v) {
        return new Point3(x - v.x(), y - v.y(), z - v.z());
    }
}
