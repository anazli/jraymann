package com.org.raymann.mathtools;

public class Vec3 {
    private Float x;
    private Float y;
    private Float z;

    public Vec3() {
        this(0.f, 0.f, 0.f);
    }

    public Vec3(Float x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vec3 create() {
        return new Vec3();
    }

    public static Vec3 create(Float x, Float y, Float z) {
        return new Vec3(x, y, z);
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

    public Vec3 normalVector() {
        Float l = length();
        return new Vec3(x / l, y / l, z / l);
    }

    public Vec3 plus(Vec3 v) {
        return new Vec3(x + v.x(), y + v.y(), z + v.z());
    }

    public Vec3 minus(Vec3 v) {
        return new Vec3(x - v.x(), y - v.y(), z - v.z());
    }

    public Vec3 times(Vec3 v) {
        return new Vec3(x * v.x(), y * v.y(), z * v.z());
    }

    public Vec3 times(Float f) {
        return new Vec3(x * f, y * f, z * f);
    }

    public Vec3 over(Vec3 v) {
        return new Vec3(x / v.x(), y / v.y(), z / v.z());
    }

    public Vec3 over(Float f) {
        return new Vec3(x / f, y / f, z / f);
    }

    public Float dot(Vec3 v) {
        return x * v.x() + y * v.y() + z * v.z();
    }

    public Vec3 cross(Vec3 v) {
        Float a = y * v.z() - z * v.y();
        Float b = z * v.x() - x * v.z();
        Float c = x * v.y() - y * v.x();
        return new Vec3(a, b, c);
    }

    public boolean equals(Vec3 v) {
        return (Math.abs(x - v.x()) < Constants.EPSILON) &&
                (Math.abs(y - v.y()) < Constants.EPSILON) &&
                (Math.abs(z - v.z()) < Constants.EPSILON);
    }

    public Vec3 opposite() {
        return new Vec3(-x, -y, -z);
    }

    public String getInfoStr() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
