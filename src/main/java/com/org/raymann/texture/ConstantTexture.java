package com.org.raymann.texture;

import com.org.raymann.color.Color;

public class ConstantTexture extends Texture {

    public ConstantTexture() {
        super(Color.create());
    }

    public ConstantTexture(Color c) {
        super(c);
    }

    public static ConstantTexture create() {
        return new ConstantTexture();
    }

    public static ConstantTexture create(Color c) {
        return new ConstantTexture(c);
    }

    public Color value(Color c) {
        return color;
    }
}
