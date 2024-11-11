package com.org.raymann.mathtools;

public class Vector2D {
    private Float x;
    private Float y;

    public Vector2D() {
        this(0.f, 0.f);
    }

    public Vector2D(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2D create() {
        return new Vector2D();
    }

    public static Vector2D create(Float x, Float y) {
        return new Vector2D(x, y);
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

    public void set(int index, Float value) {
        if(index > 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        switch (index) {
            case 0: x = value;break;
            case 1: y = value;break;
        }
    }

    public Float get(int index) {
        if(index < 0 || index > 1) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            return x;
        }
        return y;
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

    public Vector2D normalVector() {
        Float l = length();
        return new Vector2D(x / l, y / l);
    }

    public Vector2D plus(Vector2D v) {
        return new Vector2D(x + v.x(), y + v.y());
    }

    public Vector2D minus(Vector2D v) {
        return new Vector2D(x - v.x(), y - v.y());
    }

    public Vector2D times(Vector2D v) {
        return new Vector2D(x * v.x(), y * v.y());
    }

    public Vector2D times(Float f) {
        return new Vector2D(x * f, y * f);
    }

    public Vector2D over(Vector2D v) {
        return new Vector2D(x / v.x(), y / v.y());
    }

    public Vector2D over(Float f) {
        return new Vector2D(x / f, y / f);
    }

    public Float dot(Vector2D v) {
        return x * v.x() + y * v.y();
    }

    public boolean equals(Vector2D v) {
        return (Math.abs(x - v.x()) < Constants.EPSILON) &&
                (Math.abs(y - v.y()) < Constants.EPSILON);
    }

    public Vector2D opposite() {
        return new Vector2D(-x, -y);
    }

    public String getInfoStr() {
        return "(" + x + "," + y + ")";
    }
}
