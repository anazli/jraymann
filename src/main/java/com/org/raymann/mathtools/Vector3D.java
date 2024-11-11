package com.org.raymann.mathtools;

public class Vector3D {
    private Float x;
    private Float y;
    private Float z;

    public Vector3D() {
        this(0.f, 0.f, 0.f);
    }

    public Vector3D(Float x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3D create() {
        return new Vector3D();
    }

    public static Vector3D create(Float x, Float y, Float z) {
        return new Vector3D(x, y, z);
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

    public void set(int index, Float value) {
        if(index > 2 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        switch (index) {
            case 0: x = value;break;
            case 1: y = value;break;
            case 2: z = value;break;
        }
    }

    public Float get(int index) {
        if(index < 0 || index > 2) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            return x;
        }
        else if(index == 1) {
            return y;
        }
        return z;
    }

    public Float length() {
        double d = Math.sqrt((x * x) + (y * y) + (z * z));
        return (float) d;
    }

    public Vector3D normalVector() {
        Float l = length();
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

    public Vector3D times(Float f) {
        return new Vector3D(x * f, y * f, z * f);
    }

    public Vector3D over(Vector3D v) {
        return new Vector3D(x / v.x(), y / v.y(), z / v.z());
    }

    public Vector3D over(Float f) {
        return new Vector3D(x / f, y / f, z / f);
    }

    public Float dot(Vector3D v) {
        return x * v.x() + y * v.y() + z * v.z();
    }

    public Vector3D cross(Vector3D v) {
        Float a = y * v.z() - z * v.y();
        Float b = z * v.x() - x * v.z();
        Float c = x * v.y() - y * v.x();
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
