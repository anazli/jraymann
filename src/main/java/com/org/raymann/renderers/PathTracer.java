package com.org.raymann.renderers;

import com.org.raymann.color.Color;
import com.org.raymann.composite.SceneElement;
import com.org.raymann.mathtools.Ray;

public class PathTracer extends Renderer{

    public void visitSceneElement(SceneElement element, Ray ray) {

    }

    public Color computeColor(SceneElement world, Ray ray) {
        return new Color();
    }
}
