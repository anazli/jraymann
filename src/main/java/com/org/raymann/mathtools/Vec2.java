package com.org.raymann.mathtools;

public class Vec2 {
    private Float x;
    private Float y;

    public Vec2() {
        this(0.f, 0.f);
    }

    public Vec2(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public static Vec2 create() {
        return new Vec2();
    }

    public static Vec2 create(Float x, Float y) {
        return new Vec2(x, y);
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public void setAll(Float f) {
        x = y = f;
    }

    public Float x() {
        return x;
    }

    public Float y() {
        return y;
    }

    public Float length() {
        double d = Math.sqrt((x * x) + (y * y));
        return (float) d;
    }

    public Vec2 normalVector() {
        Float l = length();
        return new Vec2(x / l, y / l);
    }

    public Vec2 plus(Vec2 v) {
        return new Vec2(x + v.x(), y + v.y());
    }

    public Vec2 minus(Vec2 v) {
        return new Vec2(x - v.x(), y - v.y());
    }

    public Vec2 times(Vec2 v) {
        return new Vec2(x * v.x(), y * v.y());
    }

    public Vec2 times(Float f) {
        return new Vec2(x * f, y * f);
    }

    public Vec2 over(Vec2 v) {
        return new Vec2(x / v.x(), y / v.y());
    }

    public Vec2 over(Float f) {
        return new Vec2(x / f, y / f);
    }

    public Float dot(Vec2 v) {
        return x * v.x() + y * v.y();
    }

    public boolean equals(Vec2 v) {
        return (Math.abs(x - v.x()) < Constants.EPSILON) &&
                (Math.abs(y - v.y()) < Constants.EPSILON);
    }

    public Vec2 opposite() {
        return new Vec2(-x, -y);
    }

    public String getInfoStr() {
        return "(" + x + "," + y + ")";
    }
}
