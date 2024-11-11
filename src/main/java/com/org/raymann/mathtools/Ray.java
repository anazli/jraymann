package com.org.raymann.mathtools;

public class Ray {
    private Point3D origin;
    private Vector3D direction;

    public Ray() {
        this(Point3D.create(), Vector3D.create());
    }

    public Ray(Point3D o, Vector3D d) {
        origin = Point3D.create(o);
        direction = Vector3D.create(d);
    }

    public static Ray create() {
        return new Ray();
    }

    public static Ray create(Point3D o, Vector3D d) {
        return new Ray(o, d);
    }

    public void setOrigin(Point3D o) {
        origin.set(o);
    }

    public void setDirection(Vector3D v) {
        direction.set(v);
    }

    public Point3D origin() {
        return origin;
    }

    public Vector3D direction() {
        return direction;
    }

    public Point3D position(Float t) {
        return origin().plus(direction().times(t));
    }
}
