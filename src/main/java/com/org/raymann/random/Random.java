package com.org.raymann.random;

import com.org.raymann.mathtools.Vector3D;

import java.security.SecureRandom;

public class Random {
    private static final SecureRandom random = new SecureRandom();

    public static Vector3D randomVectorOnUnitSphere() {
        float xi1 = 0.f;
        float xi2 = 0.f;
        float dsq = 2.f;
        while (dsq >= 1.f) {
            xi1 = 1.f - 2.f * random.nextFloat();
            xi2 = 1.f - 2.f * random.nextFloat();
            dsq = xi1 * xi1 + xi2 * xi2;
        }

        float ranH = 2.f * (float) Math.sqrt(1.f - dsq);
        float dmx = xi1 * ranH;
        float dmy = xi2 * ranH;
        float dmz = 1.f - 2.f * dsq;

        return new Vector3D(dmx, dmy, dmz);
    }
}
