package com.org.raymann.container;

import com.org.raymann.color.Color;

import java.util.ArrayList;

public class Canvas {
    private Integer width;
    private Integer height;
    private String outputFileName;
    private ArrayList<ArrayList<Color>> pixels;

    private void initializePixels() {
        if(pixels != null) {
            return;
        }

        pixels = new ArrayList<ArrayList<Color>>();
        for(int i = 0 ; i < width ; ++i) {
            ArrayList<Color> v = new ArrayList<Color>();
            for(int j = 0 ; j < height ; ++j) {
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
}
