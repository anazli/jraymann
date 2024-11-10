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
        data.add(Vec4.create(row4.x(), row4.y(), row4.z(), row4.w()));
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

    public Vec4 times(Vec4 v) {
        Vec4 ret = Vec4.create();
        ret.setX(data.get(0).dot(v));
        ret.setY(data.get(1).dot(v));
        ret.setZ(data.get(2).dot(v));
        ret.setW(data.get(3).dot(v));
        return ret;
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
        float det = 0.f;
        for(int j = 0 ; j < LENGTH ; ++j) {
            det += data.get(0).get(j) * coFactor(0, j);
        }
        return det;
    }

    public Matrix3D minor(int i, int j) {
        Matrix3D m = Matrix3D.create();
        int yy = 0;
        for(int y = 0 ; y < LENGTH ; ++y) {
            if(y == j) continue;
            int xx = 0;
            for(int x = 0 ; x < LENGTH ; ++x) {
                if(x == i) continue;
                m.set(xx, yy, data.get(x).get(y));
                xx++;
            }
            yy++;
        }
        return m;
    }

    public Float coFactor(int i, int j) {
        Matrix3D m = minor(i, j);
        return (float)Math.pow(-1.f, i + j + 2) * m.determinant();
    }

    public Matrix4D inverse() {
        float det = determinant();
        if(det == 0) throw new RuntimeException("Matrix is not invertible!");
        Matrix4D inv = Matrix4D.create();
        for(int i = 0 ; i < LENGTH ; ++i) {
            for(int j = 0 ; j < LENGTH ; ++j) {
                float c = coFactor(i, j);
                inv.set(j, i, c / det);
            }
        }
        return inv;
    }

    public static Matrix4D translation(Float x, Float y, Float z) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(0, 3, x);
        ret.set(1, 3, y);
        ret.set(2, 3, z);
        return ret;
    }

    public static Matrix4D translation(Vec3 v) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(0, 3, v.x());
        ret.set(1, 3, v.y());
        ret.set(2, 3, v.z());
        return ret;
    }

    public static Matrix4D scale(Float x, Float y, Float z) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(0, 0, x);
        ret.set(1, 1, y);
        ret.set(2, 2, z);
        return ret;
    }

    public static Matrix4D scale(Vec3 v) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(0, 0, v.x());
        ret.set(1, 1, v.y());
        ret.set(2, 2, v.z());
        return ret;
    }

    public static Matrix4D rotationOverX(Float rad) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(1, 1, (float)Math.cos(rad));
        ret.set(1, 2, -(float)Math.sin(rad));
        ret.set(2, 1, (float)Math.sin(rad));
        ret.set(2, 2, (float)Math.cos(rad));
        return ret;
    }

    public static Matrix4D rotationOverY(Float rad) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(0, 0, (float)Math.cos(rad));
        ret.set(0, 2, (float)Math.sin(rad));
        ret.set(2, 0, -(float)Math.sin(rad));
        ret.set(2, 2, (float)Math.cos(rad));
        return ret;
    }

    public static Matrix4D rotationOverZ(Float rad) {
        Matrix4D ret = Matrix4D.identity();
        ret.set(0, 0, (float)Math.cos(rad));
        ret.set(0, 1, -(float)Math.sin(rad));
        ret.set(1, 0, (float)Math.sin(rad));
        ret.set(1, 1, (float)Math.cos(rad));
        return ret;
    }

    /*public static Matrix4D transformationChaining(Matrix4D a, Matrix4D b, Matrix4D c) {
        Matrix4D m = b.times(c);
        return m.times(a);
    }*/
}
