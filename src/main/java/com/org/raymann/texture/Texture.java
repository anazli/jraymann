package com.org.raymann.texture;

import com.org.raymann.color.Color;

public abstract class Texture {
    protected Color color;

    public Texture(Color c) {
        color = c;
    }

    public static Texture create(TextureType type, Color c) {
        Texture texture = null;
        switch (type) {
            case CONSTANT_TEXTURE: texture = ConstantTexture.create(c);
        }
        return texture;
    }

    public abstract Color value(Color c);
}
