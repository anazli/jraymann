package com.org.raymann.mathtools;

public class Point3D {
    private float x;
    private float y;
    private float z;

    public Point3D() {
        this(0.f, 0.f, 0.f);
    }

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point3D create() {
        return new Point3D();
    }

    public static Point3D create(float x, float y, float z) {
        return new Point3D(x, y, z);
    }

    public static Point3D create(Point3D p) {
        return new Point3D(p.x(), p.y(), p.z());
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void set(Point3D p) {
        x = p.x();
        y = p.y();
        z = p.z();
    }

    public void setAll(float f) {
        x = y = z = f;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float z() {
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
