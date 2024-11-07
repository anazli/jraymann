package com.org.raymann.container;

import com.org.raymann.color.Color;
import com.org.raymann.mathtools.Vec3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @Test
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

    @Test
    public void givenPixelIsWrittenWhenItReturnsPixelThenItIsTheRightOne() {
        Canvas canvas = new Canvas(800, 600);
        Color green = Color.create(0.f, 1.f, 0.f);
        canvas.writePixel(500, 500, green);
        Color writtenPixel = canvas.getPixel(500, 500);
        assertTrue(green.equals(writtenPixel));
    }

    @Test
    public void givenPixelArrayWhenSavesThenOutputFileIsCorrect() throws IOException {
        Canvas c = new Canvas(5, 3);
        Color color1 = Color.create(1.5f, 0.f, 0.f);
        Color color2 = Color.create(0.f, 0.5f, 0.f);
        Color color3 = Color.create(-0.5f, 0.f, 1.f);

        c.writePixel(0, 0, color1);
        c.writePixel(2, 1, color2);
        c.writePixel(4, 2, color3);
        c.setOutputFileName("test1.ppm");
        c.save();
    }
}