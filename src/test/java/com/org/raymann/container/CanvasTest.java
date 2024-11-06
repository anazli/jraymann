package com.org.raymann.container;

import com.org.raymann.color.Color;
import com.org.raymann.mathtools.Vec3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {

    @Test
    public void givenNullCanvasWhenIsCreatedThenAllPixelsAreBlack() {
        Canvas c = new Canvas(10, 20);
        assertEquals(c.getWidth(), 10);
        assertEquals(c.getHeight(), 20);
        Color expectedColor = Color.create();
        Color actualColor = c.getPixels().get(5).get(5);
        assertTrue(expectedColor.equals(actualColor));
    }

    public void givenPixelWithColorWhenItWritesThenItIsCorrect() {
        Canvas canvas = new Canvas(800, 600);
        Color red = Color.create(1.f, 0.f, 0.f);
        Color black = Color.create(0.f, 0.f, 0.f);
        canvas.writePixel(500, 500, red);
        Color writtenPixel = canvas.getPixels().get(500).get(500);
        Color unwrittenPixel = canvas.getPixels().get(345).get(555);
        assertTrue(red.equals(writtenPixel));
        assertTrue(black.equals(unwrittenPixel));
    }
}