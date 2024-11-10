package com.org.raymann.mathtools;

import java.util.ArrayList;

public class Matrix3D {
    private ArrayList<Vec3> data;
    private static final int LENGTH = 3;

    public Matrix3D() {
        data = new ArrayList<>();
        data.add(Vec3.create());
        data.add(Vec3.create());
        data.add(Vec3.create());
    }

    public Matrix3D(Vec3 row1, Vec3 row2, Vec3 row3) {
        data = new ArrayList<>();
        data.add(Vec3.create(row1.x(), row1.y(), row1.z()));
        data.add(Vec3.create(row2.x(), row2.y(), row2.z()));
        data.add(Vec3.create(row3.x(), row3.y(), row3.z()));
    }

    public static Matrix3D create() {
        return new Matrix3D();
    }

    public static Matrix3D create(Vec3 row1, Vec3 row2, Vec3 row3) {
        return new Matrix3D(row1, row2, row3);
    }

    public static Matrix3D identity() {
        return new Matrix3D(Vec3.create(1.f, 0.f, 0.f),
                Vec3.create(0.f, 1.f, 0.f),
                Vec3.create(0.f, 0.f, 1.f));
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

    public Matrix3D plus(Matrix3D m) {
        return new Matrix3D(this.data.get(0).plus(m.data.get(0)),
                            this.data.get(1).plus(m.data.get(1)),
                            this.data.get(2).plus(m.data.get(2)));
    }

    public Matrix3D minus(Matrix3D m) {
        return new Matrix3D(this.data.get(0).minus(m.data.get(0)),
                            this.data.get(1).minus(m.data.get(1)),
                            this.data.get(2).minus(m.data.get(2)));
    }

    public Matrix3D times(Matrix3D m) {
        Vec3 row1 = data.get(0);
        Vec3 row2 = data.get(1);
        Vec3 row3 = data.get(2);

        Vec3 col1 = Vec3.create(m.get(0, 0), m.get(1, 0),m.get(2, 0));
        Vec3 col2 = Vec3.create(m.get(0, 1), m.get(1, 1),m.get(2, 1));
        Vec3 col3 = Vec3.create(m.get(0, 2), m.get(1, 2),m.get(2, 2));

        Vec3 returnRow1 = Vec3.create(row1.dot(col1), row1.dot(col2), row1.dot(col3));
        Vec3 returnRow2 = Vec3.create(row2.dot(col1), row2.dot(col2), row2.dot(col3));
        Vec3 returnRow3 = Vec3.create(row3.dot(col1), row3.dot(col2), row3.dot(col3));

        return Matrix3D.create(returnRow1, returnRow2, returnRow3);
    }

    public Matrix3D transpose() {
        Matrix3D m = Matrix3D.create();
        m.set(0, 0, get(0,0));
        m.set(1, 0, get(0,1));
        m.set(2, 0, get(0,2));

        m.set(0, 1, get(1,0));
        m.set(1, 1, get(1,1));
        m.set(2, 1, get(1,2));

        m.set(0, 2, get(2,0));
        m.set(1, 2, get(2,1));
        m.set(2, 2, get(2,2));

        return m;
    }

    public float trace() {
        return get(0,0) + get(1, 1) + get(2,2);
    }

    public Float determinant() {
        float r1 = get(0,0) *
                (get(1,1) * get(2,2) - get(1,2) * get(2,1));
        float r2 = get(0,1) *
                (get(1,0) * get(2,2) - get(1,2) * get(2,0));
        float r3 = get(0,2) *
                (get(1,0) * get(2,1) - get(1,1) * get(2,0));

        return r1 - r2 + r3;
    }
}
