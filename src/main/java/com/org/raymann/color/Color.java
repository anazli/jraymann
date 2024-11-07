package com.org.raymann.color;

import com.org.raymann.mathtools.Vec3;

public class Color {
    private Vec3 value;

    public Color() {
        this(Vec3.create());
    }

    public Color(Vec3 v) {
        value = v;
    }

    public static Color create() {
        return new Color();
    }

    public static Color create(Float r, Float g, Float b) {
        return new Color(Vec3.create(r,g,b));
    }

    public boolean equals(Color other) {
        return value.equals(other.rgb());
    }

    public void setRed(Float r) {
        value.setX(r);
    }

    public void setGreen(Float g) {
        value.setX(g);
    }

    public void setBlue(Float b) {
        value.setX(b);
    }

    public Float red() {
        return value.x();
    }

    public Float green() {
        return value.y();
    }

    public Float blue() {
        return value.z();
    }

    public Vec3 rgb() {
        return value;
    }

    public void setRgb(Vec3 v) {
        value = v;
    }

    public void setRgb(Float r, Float g, Float b) {
        value.setX(r);
        value.setY(g);
        value.setZ(b);
    }

    public Color plus(Color c) {
        return new Color(value.plus(c.rgb()));
    }

    public Color minus(Color c) {
        return new Color(value.minus(c.rgb()));
    }

    public Color times(Float f) {
        return new Color(value.times(f));
    }

    public Color times(Color c) {
        return new Color(value.times(c.rgb()));
    }
}
