package com.org.raymann.mathtools;

public class Vec4 {
    private Float x;
    private Float y;
    private Float z;
    private Float w;

    public Vec4() {
        this(0.f, 0.f, 0.f, 0.f);
    }

    public Vec4(Float x, Float y, Float z, Float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static Vec4 create() {
        return new Vec4();
    }

    public static Vec4 create(Float x, Float y, Float z, Float w) {
        return new Vec4(x, y, z, w);
    }

    public static Vec4 create(Vec3 v) {
        return new Vec4(v.x(), v.y(), v.z(), 0.f);
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

    public Vec4 normalVector() {
        Float l = length();
        return new Vec4(x / l, y / l, z / l, w / l);
    }

    public Vec4 plus(Vec4 v) {
        return new Vec4(x + v.x(), y + v.y(), z + v.z(), w + v.w());
    }

    public Vec4 minus(Vec4 v) {
        return new Vec4(x - v.x(), y - v.y(), z - v.z(), w - v.w());
    }

    public Vec4 times(Vec4 v) {
        return new Vec4(x * v.x(), y * v.y(), z * v.z(), w * v.w());
    }

    public Vec4 times(Float f) {
        return new Vec4(x * f, y * f, z * f, w * f);
    }

    public Vec4 over(Vec4 v) {
        return new Vec4(x / v.x(), y / v.y(), z / v.z(), w / v.w());
    }

    public Vec4 over(Float f) {
        return new Vec4(x / f, y / f, z / f, w / f);
    }

    public Float dot(Vec4 v) {
        return x * v.x() + y * v.y() + z * v.z() + w * v.w();
    }

    public boolean equals(Vec4 v) {
        return (Math.abs(x - v.x()) < Constants.EPSILON) &&
                (Math.abs(y - v.y()) < Constants.EPSILON) &&
                (Math.abs(z - v.z()) < Constants.EPSILON) &&
                (Math.abs(w - v.w()) < Constants.EPSILON);
    }

    public Vec4 opposite() {
        return new Vec4(-x, -y, -z, -w);
    }

    public String getInfoStr() {
        return "(" + x + "," + y + "," + z + "," + w + ")";
    }
}
