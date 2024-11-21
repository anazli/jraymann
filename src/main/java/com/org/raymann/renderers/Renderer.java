package com.org.raymann.renderers;

import com.org.raymann.color.Color;
import com.org.raymann.composite.SceneElement;
import com.org.raymann.mathtools.Ray;

public abstract class Renderer {
    protected Color outputcolor;

    public abstract void visitSceneElement(SceneElement element, Ray ray);
    public abstract Color computeColor(SceneElement world, Ray ray);
}
