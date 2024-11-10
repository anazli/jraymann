package com.org.raymann.mathtools;

import java.util.ArrayList;

public class Matrix4D {
    private ArrayList<Vec4> data;
    private static final int LENGTH = 4;

    public Matrix4D() {
        data = new ArrayList<>();
        data.add(Vec4.create());
        data.add(Vec4.create());
        data.add(Vec4.create());
        data.add(Vec4.create());
    }

    public Matrix4D(Vec4 row1, Vec4 row2, Vec4 row3, Vec4 row4) {
        data = new ArrayList<>();
        data.add(Vec4.create(row1.x(), row1.y(), row1.z(), row1.w()));
        data.add(Vec4.create(row2.x(), row2.y(), row2.z(), row2.w()));
        data.add(Vec4.create(row3.x(), row3.y(), row3.z(), row3.w()));
        data.add(Vec4.create(row3.x(), row3.y(), row3.z(), row4.w()));
    }

    public static Matrix4D create() {
        return new Matrix4D();
    }

    public static Matrix4D create(Vec4 row1, Vec4 row2, Vec4 row3, Vec4 row4) {
        return new Matrix4D(row1, row2, row3, row4);
    }

    public static Matrix4D identity() {
        return new Matrix4D(Vec4.create(1.f, 0.f, 0.f, 0.f),
                            Vec4.create(0.f, 1.f, 0.f, 0.f),
                            Vec4.create(0.f, 0.f, 1.f, 0.f),
                            Vec4.create(0.f, 0.f, 0.f, 1.f));
    }

    public void set(int row, int col, Float val) {
        if(row >= LENGTH || row < 0) {
            throw new IndexOutOfBoundsException();
        }
        data.get(row).set(col, val);
    }

    public Float get(int row, int col) {
        if(row >= LENGTH || row < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(row).get(col);
    }

    public Matrix4D plus(Matrix4D m) {
        return new Matrix4D(this.data.get(0).plus(m.data.get(0)),
                            this.data.get(1).plus(m.data.get(1)),
                            this.data.get(2).plus(m.data.get(2)),
                            this.data.get(3).plus(m.data.get(3)));
    }

    public Matrix4D minus(Matrix4D m) {
        return new Matrix4D(this.data.get(0).minus(m.data.get(0)),
                            this.data.get(1).minus(m.data.get(1)),
                            this.data.get(2).minus(m.data.get(2)),
                            this.data.get(3).minus(m.data.get(3)));
    }

    public Matrix4D times(Matrix4D m) {
        Vec4 row1 = data.get(0);
        Vec4 row2 = data.get(1);
        Vec4 row3 = data.get(2);
        Vec4 row4 = data.get(3);

        Vec4 col1 = Vec4.create(m.get(0, 0), m.get(1, 0),m.get(2, 0), m.get(3,0));
        Vec4 col2 = Vec4.create(m.get(0, 1), m.get(1, 1),m.get(2, 1), m.get(3,1));
        Vec4 col3 = Vec4.create(m.get(0, 2), m.get(1, 2),m.get(2, 2), m.get(3,2));
        Vec4 col4 = Vec4.create(m.get(0, 3), m.get(1, 3),m.get(2, 3), m.get(3,3));

        Vec4 returnRow1 = Vec4.create(row1.dot(col1), row1.dot(col2), row1.dot(col3), row1.dot(col4));
        Vec4 returnRow2 = Vec4.create(row2.dot(col1), row2.dot(col2), row2.dot(col3), row2.dot(col4));
        Vec4 returnRow3 = Vec4.create(row3.dot(col1), row3.dot(col2), row3.dot(col3), row3.dot(col4));
        Vec4 returnRow4 = Vec4.create(row4.dot(col1), row4.dot(col2), row4.dot(col3), row4.dot(col4));

        return Matrix4D.create(returnRow1, returnRow2, returnRow3, returnRow4);
    }

    public Matrix4D transpose() {
        Matrix4D m = Matrix4D.create();
        m.set(0, 0, get(0,0));
        m.set(1, 0, get(0,1));
        m.set(2, 0, get(0,2));
        m.set(3, 0, get(0,3));

        m.set(0, 1, get(1,0));
        m.set(1, 1, get(1,1));
        m.set(2, 1, get(1,2));
        m.set(3, 1, get(1,3));

        m.set(0, 2, get(2,0));
        m.set(1, 2, get(2,1));
        m.set(2, 2, get(2,2));
        m.set(3, 2, get(2,3));

        m.set(0, 3, get(3,0));
        m.set(1, 3, get(3,1));
        m.set(2, 3, get(3,2));
        m.set(3, 3, get(3,3));

        return m;
    }

    public float trace() {
        return get(0,0) + get(1, 1) + get(2,2) + get(3,3);
    }

    public Float determinant() {
        return 0.f;
    }
}
