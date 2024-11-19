package com.org.raymann.materials;

import com.org.raymann.color.Color;
import com.org.raymann.composite.HitRecord;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import com.org.raymann.random.Random;
import com.org.raymann.texture.Texture;

public class Lambertian extends Material {

    Lambertian(Texture t) {
        super(t);
    }

    public static Lambertian create(Texture t) {
        return new Lambertian(t);
    }

    public boolean scatter(Ray ray, HitRecord record, Color attenuation) {
        Point3D point = record.hitPoint(ray);
        Point3D target =
                point.plus(Random.randomVectorOnUnitSphere()).plus(record.getNormalAtHitPoint());
        record.setScatteredRay(Ray.create(point, target.minus(point)));
        attenuation = texture.value(attenuation);
        return true;
    }
}
