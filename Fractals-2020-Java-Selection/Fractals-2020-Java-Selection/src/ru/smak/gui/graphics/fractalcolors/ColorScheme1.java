package ru.smak.gui.graphics.fractalcolors;

import java.awt.*;

public class ColorScheme1 implements Colorizer{

    @Override
    public Color getColor(float x) {
        if(x!=1){
            float r, g, b;
            r = (float)Math.abs(Math.sin(x)*Math.cos(x));
            g = x*x;
            b = x;
            return new Color(r, g, b);
        }
        else return Color.BLACK;
    }
}
