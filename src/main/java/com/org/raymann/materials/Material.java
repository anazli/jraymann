package com.org.raymann.materials;

import com.org.raymann.composite.HitRecord;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import com.org.raymann.texture.Texture;

public abstract class Material {
    protected Texture texture;

    public static Material create(MaterialType type, Texture t) {
        Material material = null;
        switch (type) {
            case LAMBERTIAN:
                material = Lambertian.create(t);
        }
        return material;
    }

    public abstract boolean scatter(Ray ray, HitRecord record, Vector3D attenuation);

    protected Material(Texture t) {
        texture = t;
    }

    protected float schlick(float cosine, float refIdx) {
        float r0 = (1.f - refIdx) / (1.f + refIdx);
        r0 = r0 * r0;
        return r0 + (1.f - r0) * (float) Math.pow((1.f - cosine), 5);
    }

    protected Vector3D reflect(Vector3D v, Vector3D n) {
        return v.minus(n.times(2.f * v.dot(n)));
    }

    protected boolean refract(Vector3D v, Vector3D n, float niOverNt,
                              Vector3D refracted) {
        Vector3D uv = v.normalVector();
        float dt = uv.dot(n);
        float discriminant = 1.f - niOverNt * niOverNt * (1.f - dt * dt);
        if (discriminant > 0.f) {
            Vector3D a = (uv.minus(n.times(dt))).times(niOverNt);
            Vector3D b = n.times((float) Math.sqrt(discriminant));
            refracted = a.minus(b);
            return true;
        } else
            return false;
    }

}
