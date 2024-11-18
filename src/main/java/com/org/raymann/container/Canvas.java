package com.org.raymann.container;

import com.org.raymann.color.Color;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Canvas {
    private final Integer width;
    private final Integer height;
    private String outputFileName;
    private ArrayList<ArrayList<Color>> pixels;

    private void initializePixels() {
        if (pixels != null) {
            return;
        }

        pixels = new ArrayList<ArrayList<Color>>();
        for (int i = 0; i < width; ++i) {
            ArrayList<Color> v = new ArrayList<Color>();
            for (int j = 0; j < height; ++j) {
                v.add(Color.create());
            }
            pixels.add(v);
        }
    }

    public Canvas(Integer w, Integer h) {
        width = w;
        height = h;
        initializePixels();
    }

    public void setOutputFileName(String fn) {
        outputFileName = fn;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public ArrayList<ArrayList<Color>> getPixels() {
        return pixels;
    }

    public void writePixel(Integer row, Integer col, Color pixel) {
        pixels.get(row).set(col, pixel);
    }

    public Color getPixel(Integer i, Integer j) {
        return pixels.get(i).get(j);
    }

    public void save() throws IOException {
        try (PrintWriter writer = new PrintWriter(outputFileName, StandardCharsets.UTF_8)) {
            writer.write("P3\n");
            writer.write(width.toString() + " " + height.toString() + "\n");
            writer.write("255\n");
            for (int j = 0; j < height; ++j) {
                for (int i = 0; i < width; ++i) {
                    writePixel(i, j, pixels.get(i).get(j).times(255.f));
                    if (pixels.get(i).get(j).red() > 255.f)
                        getPixel(i, j).setRed(255.f);
                    if (pixels.get(i).get(j).red() < 0.f)
                        getPixel(i, j).setRed(0.f);
                    if (pixels.get(i).get(j).green() > 255.f)
                        getPixel(i, j).setGreen(255.f);
                    if (pixels.get(i).get(j).green() < 0.f)
                        getPixel(i, j).setGreen(0.f);
                    if (pixels.get(i).get(j).blue() > 255.f)
                        getPixel(i, j).setBlue(255.f);
                    if (pixels.get(i).get(j).blue() < 0.f)
                        getPixel(i, j).setBlue(0.f);

                    int r = getPixel(i, j).red().intValue();
                    int g = getPixel(i, j).green().intValue();
                    int b = getPixel(i, j).blue().intValue();

                    writer.write(r + " " +
                            g + " " +
                            b + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
