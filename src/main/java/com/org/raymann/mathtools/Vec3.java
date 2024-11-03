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

    public Float length() {
        double d = Math.sqrt((x * x) + (y * y) + (z * z));
        return (float) d;
    }

    public Vec3 normalVector() {
        Float l = length();
        return new Vec3(x/l, y/l, z/l);
    }

    public Vec3 plus(Vec3 v) {
        return new Vec3(x + v.x(), y + v.y(), z + v.z());
    }

    public Vec3 times(Vec3 v) {
        return new Vec3(x * v.x(), y * v.y(), z * v.z());
    }

    public Vec3 over(Vec3 v) {
        return new Vec3(x/v.x(), y/v.y(), z/v.z());
    }

    public Float dot(Vec3 v) {
        return x * v.x() + y * v.y() + z * v.z();
    }
}
