package com.org.raymann.mathtools;

public class Point3D {
    private Float x;
    private Float y;
    private Float z;

    public Point3D() {
        this(0.f, 0.f, 0.f);
    }

    public Point3D(Float x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point3D create() {
        return new Point3D();
    }

    public static Point3D create(Float x, Float y, Float z) {
        return new Point3D(x,y,z);
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

    public boolean equals(Point3D p) {
        return (Math.abs(x - p.x()) < Constants.EPSILON) &&
                (Math.abs(y - p.y()) < Constants.EPSILON) &&
                (Math.abs(z - p.z()) < Constants.EPSILON);
    }

    public Point3D plus(Vector3D v) {
        return new Point3D(x + v.x(), y + v.y(), z + v.z());
    }

    public Vector3D minus(Point3D p) {
        return new Vector3D(x - p.x(), y - p.y(), z - p.z());
    }

    public Point3D minus(Vector3D v) {
        return new Point3D(x - v.x(), y - v.y(), z - v.z());
    }
}
