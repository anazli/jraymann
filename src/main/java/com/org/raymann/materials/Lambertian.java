package com.org.raymann.materials;

import com.org.raymann.composite.HitRecord;
import com.org.raymann.mathtools.Ray;
import com.org.raymann.mathtools.Vector3D;
import com.org.raymann.texture.Texture;

public class Lambertian extends Material {

    Lambertian(Texture t) {
        super(t);
    }

    public static Lambertian create(Texture t) {
        return new Lambertian(t);
    }

    public boolean scatter(Ray ray, HitRecord record, Vector3D attenuation) {
        /*auto point = rec.point(r_in);
        auto target =
                point + Random::randomVectorOnUnitSphere() + rec.object->normal(point);
        scattered = Ray(point, target - point);
        m_pdf->setFromW(rec.object->normal(point));
        attenuation = m_tex->value(0, 0, Vec3f());*/
        return true;
    }
}
