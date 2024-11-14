package com.org.raymann.mathtools;

import java.util.ArrayList;

public class Matrix3D {
    private ArrayList<Vector3D> data;
    private static final int LENGTH = 3;

    public Matrix3D() {
        data = new ArrayList<>();
        data.add(Vector3D.create());
        data.add(Vector3D.create());
        data.add(Vector3D.create());
    }

    public Matrix3D(Vector3D row1, Vector3D row2, Vector3D row3) {
        data = new ArrayList<>();
        data.add(row1);
        data.add(row2);
        data.add(row3);
    }

    public static Matrix3D create() {
        return new Matrix3D();
    }

    public static Matrix3D create(Vector3D row1, Vector3D row2, Vector3D row3) {
        return new Matrix3D(row1, row2, row3);
    }

    public static Matrix3D identity() {
        return new Matrix3D(Vector3D.create(1.f, 0.f, 0.f),
                Vector3D.create(0.f, 1.f, 0.f),
                Vector3D.create(0.f, 0.f, 1.f));
    }

    public void set(int row, int col, float val) {
        if(row >= LENGTH || row < 0) {
            throw new IndexOutOfBoundsException();
        }
        data.get(row).set(col, val);
    }

    public float get(int row, int col) {
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
        Vector3D row1 = data.get(0);
        Vector3D row2 = data.get(1);
        Vector3D row3 = data.get(2);

        Vector3D col1 = Vector3D.create(m.get(0, 0), m.get(1, 0),m.get(2, 0));
        Vector3D col2 = Vector3D.create(m.get(0, 1), m.get(1, 1),m.get(2, 1));
        Vector3D col3 = Vector3D.create(m.get(0, 2), m.get(1, 2),m.get(2, 2));

        Vector3D returnRow1 = Vector3D.create(row1.dot(col1), row1.dot(col2), row1.dot(col3));
        Vector3D returnRow2 = Vector3D.create(row2.dot(col1), row2.dot(col2), row2.dot(col3));
        Vector3D returnRow3 = Vector3D.create(row3.dot(col1), row3.dot(col2), row3.dot(col3));

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

    public float determinant() {
        float r1 = get(0,0) *
                (get(1,1) * get(2,2) - get(1,2) * get(2,1));
        float r2 = get(0,1) *
                (get(1,0) * get(2,2) - get(1,2) * get(2,0));
        float r3 = get(0,2) *
                (get(1,0) * get(2,1) - get(1,1) * get(2,0));

        return r1 - r2 + r3;
    }
}
