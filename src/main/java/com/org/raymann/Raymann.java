package com.org.raymann;

import com.org.raymann.composite.IntersectionRecord;
import com.org.raymann.composite.SceneElement;
import com.org.raymann.geometry.GeometricPrimitive;
import com.org.raymann.geometry.PrimitiveType;
import com.org.raymann.geometry.Sphere;
import com.org.raymann.mathtools.Point3D;
import com.org.raymann.mathtools.Ray;

/**
 * Hello world!
 */
public class Raymann {
    public static void main(String[] args) {
        System.out.println("Raymann!");
        Ray ray = Ray.create();
        IntersectionRecord record = IntersectionRecord.create();
        SceneElement element =
                GeometricPrimitive.create(PrimitiveType.SPHERE, Point3D.create(1.f,
                        1.f, 1.f), 1.f);
        System.out.println(element.intersect(ray, record));
    }
}
