package com.org.raymann.mathtools;

public class Vector3D {
    private float x;
    private float y;
    private float z;

    public Vector3D() {
        this(0.f, 0.f, 0.f);
    }

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3D create() {
        return new Vector3D();
    }

    public static Vector3D create(float x, float y, float z) {
        return new Vector3D(x, y, z);
    }

    public static Vector3D create(Vector3D v) {
        return new Vector3D(v.x(), v.y(), v.z());
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

    public void set(Vector3D v) {
        x = v.x();
        y = v.y();
        z = v.z();
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

    public void set(int index, float value) {
        if (index > 2 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        switch (index) {
            case 0:
                x = value;
                break;
            case 1:
                y = value;
                break;
            case 2:
                z = value;
                break;
        }
    }

    public float get(int index) {
        if (index < 0 || index > 2) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return x;
        } else if (index == 1) {
            return y;
        }
        return z;
    }

    public float length() {
        double d = Math.sqrt((x * x) + (y * y) + (z * z));
        return (float) d;
    }

    public Vector3D normalVector() {
        float l = length();
        return new Vector3D(x / l, y / l, z / l);
    }

    public Vector3D plus(Vector3D v) {
        return new Vector3D(x + v.x(), y + v.y(), z + v.z());
    }

    public Vector3D minus(Vector3D v) {
        return new Vector3D(x - v.x(), y - v.y(), z - v.z());
    }

    public Vector3D times(Vector3D v) {
        return new Vector3D(x * v.x(), y * v.y(), z * v.z());
    }

    public Vector3D times(float f) {
        return new Vector3D(x * f, y * f, z * f);
    }

    public Vector3D over(Vector3D v) {
        return new Vector3D(x / v.x(), y / v.y(), z / v.z());
    }

    public Vector3D over(float f) {
        return new Vector3D(x / f, y / f, z / f);
    }

    public float dot(Vector3D v) {
        return x * v.x() + y * v.y() + z * v.z();
    }

    public Vector3D cross(Vector3D v) {
        float a = y * v.z() - z * v.y();
        float b = z * v.x() - x * v.z();
        float c = x * v.y() - y * v.x();
        return new Vector3D(a, b, c);
    }

    public boolean equals(Vector3D v) {
        return (Math.abs(x - v.x()) < Constants.EPSILON) &&
                (Math.abs(y - v.y()) < Constants.EPSILON) &&
                (Math.abs(z - v.z()) < Constants.EPSILON);
    }

    public Vector3D opposite() {
        return new Vector3D(-x, -y, -z);
    }

    public String getInfoStr() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
