package com.org.raymann.mathtools;

import java.util.ArrayList;

public class Matrix2D {
    private ArrayList<Vec2> data;
    private static final int length = 2;

    public Matrix2D() {
        data = new ArrayList<>();
        data.add(Vec2.create());
        data.add(Vec2.create());
    }

    public Matrix2D(Vec2 row1, Vec2 row2) {
        Vec2 r1 = Vec2.create(row1.x(), row1.y());
        Vec2 r2 = Vec2.create(row2.x(), row2.y());
        data = new ArrayList<>();
        data.add(r1);
        data.add(r2);
    }

    public static Matrix2D create() {
        return new Matrix2D();
    }

    public static Matrix2D create(Vec2 row1, Vec2 row2) {
        return new Matrix2D(row1, row2);
    }

    public void set(int row, int col, Float val) {
        if(row > 1 || row < 0) {
            throw new IndexOutOfBoundsException();
        }
        data.get(row).set(col, val);
    }

    public Float get(int row, int col) {
        if(row > 1 || row < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(row).get(col);
    }

    public Matrix2D plus(Matrix2D m) {
        return new Matrix2D(this.data.get(0).plus(m.data.get(0)),
                            this.data.get(1).plus(m.data.get(1)));
    }

    public Matrix2D minus(Matrix2D m) {
        return new Matrix2D(this.data.get(0).minus(m.data.get(0)),
                            this.data.get(1).minus(m.data.get(1)));
    }

    public Matrix2D times(Matrix2D m) {
        Matrix2D ret = new Matrix2D();
        ret.set(0, 0, this.get(0, 0) * m.get(0, 0) +
                                   this.get(0, 1) * m.get(1, 0));
        ret.set(0, 1, this.get(0, 0) * m.get(0, 1) +
                this.get(0, 1) * m.get(1, 1));
        ret.set(1, 0, this.get(1, 0) * m.get(0, 0) +
                this.get(1, 1) * m.get(1, 0));
        ret.set(1, 1, this.get(1, 0) * m.get(0, 1) +
                this.get(1, 1) * m.get(1, 1));
        return ret;
    }
}
