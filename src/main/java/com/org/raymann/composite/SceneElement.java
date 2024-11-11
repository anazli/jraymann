package com.org.raymann.composite;

import com.org.raymann.mathtools.Ray;

public interface SceneElement {
    public boolean intersect(Ray r);
}
