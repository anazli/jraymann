package com.org.raymann.mathtools;

public class Vector2D {
    private float x;
    private float y;

    public Vector2D() {
        this(0.f, 0.f);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2D create() {
        return new Vector2D();
    }

    public static Vector2D create(float x, float y) {
        return new Vector2D(x, y);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setAll(float f) {
        x = y = f;
    }

    public void set(int index, float value) {
        if (index > 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        switch (index) {
            case 0:
                x = value;
                break;
            case 1:
                y = value;
                break;
        }
    }

    public float get(int index) {
        if (index < 0 || index > 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return x;
        }
        return y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float length() {
        double d = Math.sqrt((x * x) + (y * y));
        return (float) d;
    }

    public Vector2D normalVector() {
        float l = length();
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

    public Vector2D times(float f) {
        return new Vector2D(x * f, y * f);
    }

    public Vector2D over(Vector2D v) {
        return new Vector2D(x / v.x(), y / v.y());
    }

    public Vector2D over(float f) {
        return new Vector2D(x / f, y / f);
    }

    public float dot(Vector2D v) {
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
