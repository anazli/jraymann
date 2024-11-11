package com.org.raymann.mathtools;

public class Vector4D {
    private Float x;
    private Float y;
    private Float z;
    private Float w;

    public Vector4D() {
        this(0.f, 0.f, 0.f, 0.f);
    }

    public Vector4D(Float x, Float y, Float z, Float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static Vector4D create() {
        return new Vector4D();
    }

    public static Vector4D create(Float x, Float y, Float z, Float w) {
        return new Vector4D(x, y, z, w);
    }

    public static Vector4D fromVec3(Vector3D v) {
        return new Vector4D(v.x(), v.y(), v.z(), 0.f);
    }

    public static Vector4D fromPoint3(Point3 p) {
        return new Vector4D(p.x(), p.y(), p.z(), 1.f);
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

    public void setW(Float w) {
        this.w = w;
    }

    public void setAll(Float f) {
        x = y = z = w = f;
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

    public Float w() {
        return w;
    }

    public void set(int index, Float value) {
        if(index > 3 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        switch (index) {
            case 0: x = value;break;
            case 1: y = value;break;
            case 2: z = value;break;
            case 3: w = value;break;
        }
    }

    public Float get(int index) {
        if(index < 0 || index > 3) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            return x;
        }
        else if(index == 1) {
            return y;
        }
        else if(index == 2) {
            return z;
        }
        return w;
    }

    public Float length() {
        double d = Math.sqrt((x * x) + (y * y) + (z * z) + (w * w));
        return (float) d;
    }

    public Vector4D normalVector() {
        Float l = length();
        return new Vector4D(x / l, y / l, z / l, w / l);
    }

    public Vector4D plus(Vector4D v) {
        return new Vector4D(x + v.x(), y + v.y(), z + v.z(), w + v.w());
    }

    public Vector4D minus(Vector4D v) {
        return new Vector4D(x - v.x(), y - v.y(), z - v.z(), w - v.w());
    }

    public Vector4D times(Vector4D v) {
        return new Vector4D(x * v.x(), y * v.y(), z * v.z(), w * v.w());
    }

    public Vector4D times(Float f) {
        return new Vector4D(x * f, y * f, z * f, w * f);
    }

    public Vector4D over(Vector4D v) {
        return new Vector4D(x / v.x(), y / v.y(), z / v.z(), w / v.w());
    }

    public Vector4D over(Float f) {
        return new Vector4D(x / f, y / f, z / f, w / f);
    }

    public Float dot(Vector4D v) {
        return x * v.x() + y * v.y() + z * v.z() + w * v.w();
    }

    public boolean equals(Vector4D v) {
        return (Math.abs(x - v.x()) < Constants.EPSILON) &&
                (Math.abs(y - v.y()) < Constants.EPSILON) &&
                (Math.abs(z - v.z()) < Constants.EPSILON) &&
                (Math.abs(w - v.w()) < Constants.EPSILON);
    }

    public Vector4D opposite() {
        return new Vector4D(-x, -y, -z, -w);
    }

    public String getInfoStr() {
        return "(" + x + "," + y + "," + z + "," + w + ")";
    }
}
